package jogen.prototypes.meta.world;

import jogen.prototypes.world.Gobject;
import jogen.prototypes.meta.world.Damage;
import jogen.prototypes.world.data.Position;

public class Explosive {
  public float radius;
  public float force;
  public float temperature;
  public Damage damage;

  public Explosive(float radius, float force, float temperature, Damage damage) {
    this.radius = radius;
    this.force = force;
    this.temperature = temperature;
    this.damage = damage;
  }

  public void detonate(Position position) {
    private Position c = position;
    public Gobject[] effects = World.getObjectsFromRadius(this.radius);
    effects.heatUp(temperature);
    effects.takeDamage(this.damage);
    effects.addVelocityAwayFrom(this, this.force);
  }
}
