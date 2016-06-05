package jogen.prototypes.world.gobject;

import jogen.prototypes.world.Gobject;
import jogen.prototypes.meta.world.Explosive;
import jogen.prototypes.world.data.Composition;
import jogen.prototypes.data.render.RenderClass;

public class Bomb extends Gobject {
  public Explosive explosive;

  public Bomb(String name, Composition madeOf, RenderClass render, Explosive explosive) {
    this.name = name;
    this.madeOf = madeOf;
    this.render = render;
    this.explosive = explosive;
    this.position = World.NullPosition;
  }
  public Bomb(String name, Composition madeOf, RenderClass render, Explosive explosive, Position position) {
    this.name = name;
    this.madeOf = madeOf;
    this.render = render;
    this.explosive = explosive;
    this.position = position;
  }

  public void detonate() {
    explosive.detonate(this.position);
  }
}
