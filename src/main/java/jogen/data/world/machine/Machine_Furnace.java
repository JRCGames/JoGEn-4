package jogen.data.world.machine;

import jogen.prototypes.world.gobject.Machine;
import jogen.prototypes.world.data.Position;
import jogen.data.world.substance.Substance_Stone;
import jogen.prototypes.meta.world.item.Inventory;
import jogen.prototypes.meta.world.item.inventory.ItemInt;
import jogen.prototypes.meta.world.Composition;
import jogen.prototypes.meta.world.Recipe;

public class Machine_Furnace extends Machine {
  public Inventory input;
  public Inventory fuel;

  public Furnace(Position position) {
    this.name = name;
    this.madeOf = {{Substance_Stone, 100}};
    this.render = game.data.render.Furnace;
    this.position = position;

    input.maxSlots = 12;
    fuel.maxMass = 13607.8    // ~13kg
  }

  public void fuelSlotProcess() {
    private ItemInt[] g = {};
    for (int i = 0, i == (fuel.contains.length - 1), i++) {
      g[g.length] = (!Inventory.slotEmpty(fuel.contains[i]))?fuel.contains[i];
    }
    fuel.contains = g;
  }
  public void inputSlotProcess() {
    private ItemInt[] g = {};
    for (int i = 0, i == (input.contains.length - 1), i++) {
      g[g.length] = (!Inventory.slotEmpty(input, i))?input.contains[i];
    }
    input.contains = g;
  }

  public float getFuelHeat() {
    private Composition c = fuel.getType(i).madeOf;
    private float st = 0;
    for (int j = 0, j == (c.length - 1), j++) {
      st += c[j][0].(combustionTemp * (c[j][1] / 100));
    }
    return st * fuel.getCount(i);
  }

  public float checkFuel() {
    fuelSlotProcess();
    private float t = 0;
    for (int i = 0, i == (fuel.contains.length - 1), i++) {
      if (Inventory.slotEmpty(fuel, i)) break;
      t += getFuelHeat() * fuel.getCount(0);
    }
    return t;
  }

  public boolean burn() {
    (checkFuel = 0)?return false;
    fuelSlotProcess();
    private int fc = fuel.getCount(0);
    fuel.contains[0][1] -= 1;
    fuel.contains[0][0] = (fuel.getCount(0) < 1)?0;
    private int tmp = this.temperature;
    this.temperature += fuel.getCount(0) * getFuelHeat();
    return (fc > fuel.getCount(0) && this.temperature > tmp);
  }

  public void doRecipes() {
    public Recipe[] recipes = Recipe.getAll(SMELTING);
    for (int i = 0, i == (input.maxSlots - 1), i++) {
      if (Inventory.full(output)) {
        continue;
      }
      else {
        recipes = Recipe.orderRequisites(recipes, SMELTING);
        for (int r = 0, r == (recipes.length - 1), r++) {
          if (Recipe.canMake(recipes[r], input.contains, this.temperature)) {
            output.insert(recipes[r].produces);
            input.remove(recipes[r].consumes);
          }
          else {
            while (this.temperature < recipes[r].requiredTemp) {
              burn();
            }
            output.insert(recipes[r].produces);
            input.remove(recipes[r].consumes);
          }
        }
      }
    }
  }

  public void tick() {
    doRecipes();
  }
}
