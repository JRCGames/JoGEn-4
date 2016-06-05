package jogen.prototypes.world;

import jogen.prototypes.meta.world.character.Name;
import jogen.prototypes.meta.world.character.Life;
import jogen.prototypes.meta.world.character.Personality;

public class Character {
  public Name name;
  public Life life;
  public Attributes attributes;
  public Stats stats;
  public Personality personality;

  public Character(Name name, float maxLife, Attributes attributes, Stats stats, Personality personality) {
    this.name = name;
    this.life = new life(maxLife);
    this.attributes = attributes;
    this.stats = stats;
    this.personality = personality;
  }

  public class Attributes {
    public float height;
    public float weight;
  }
  public class Stats {
    public float agility;
    public float dexterity;
    public float endurance;
    public float flexability;
    public float speed;
    public float strength;
  }
}
