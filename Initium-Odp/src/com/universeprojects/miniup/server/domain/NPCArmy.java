package com.universeprojects.miniup.server.domain;

import com.google.appengine.api.datastore.Key;
import com.universeprojects.cacheddatastore.CachedEntity;

//This entity is used for the "NPC army" mechanic. This mechanic basically spawns monsters over time and automatically propagates them on the map so they "spread" if they are not contained by players.
public class NPCArmy extends OdpDomain {

	public NPCArmy() {
		super(new CachedEntity("NPCArmy"));
	}

	public NPCArmy(CachedEntity cachedEntity) {
		super(cachedEntity, "NPCArmy");
	}

	// (Location|type==Permanent)
	public void setLocationKey(Key locationKey) {
		getCachedEntity().setProperty("locationKey", locationKey);
	}

	public Key getLocationKey() {
		return (Key) getCachedEntity().getProperty("locationKey");
	}

	// The maximum number of mobs to spawn in this particular location. Once the max is reached, the army will attempt to propagate to other locations.
	public void setMaxSpawnCount(Long maxSpawnCount) {
		getCachedEntity().setProperty("maxSpawnCount", maxSpawnCount);
	}

	public Long getMaxSpawnCount() {
		return (Long) getCachedEntity().getProperty("maxSpawnCount");
	}

	// The minimum number of monsters that have to have spawned in the location before propagation will be considered. If this is left blank, the number of spawns must be at or over the maxSpawnCount.
	public void setMinSpawnsToPropagate(Long minSpawnsToPropagate) {
		getCachedEntity().setProperty("minSpawnsToPropagate", minSpawnsToPropagate);
	}

	public Long getMinSpawnsToPropagate() {
		return (Long) getCachedEntity().getProperty("minSpawnsToPropagate");
	}

	// This is a unique name that is generated by the propagation algorithm. It is meant to make it easier to watch what's going on from the editor.
	public void setName(String name) {
		getCachedEntity().setProperty("name", name);
	}

	public String getName() {
		return (String) getCachedEntity().getProperty("name");
	}

	// (NPCDef)
	public void setNpcDefKey(Key npcDefKey) {
		getCachedEntity().setProperty("npcDefKey", npcDefKey);
	}

	public Key getNpcDefKey() {
		return (Key) getCachedEntity().getProperty("npcDefKey");
	}

	// When a new NPCArmy node is to be created in an adjacent location, the maxSpawnCount can be randomized for that node.
	public void setPropagatedMaxSpawnCount(String propagatedMaxSpawnCount) {
		getCachedEntity().setProperty("propagatedMaxSpawnCount", propagatedMaxSpawnCount);
	}

	public String getPropagatedMaxSpawnCount() {
		return (String) getCachedEntity().getProperty("propagatedMaxSpawnCount");
	}

	// The number of times this node will attempt to duplicate itself in an adjacent location. Each time this duplication happens, the propagation count reduces by 1 and the propagated node will have a propagationCount of +1.
	public void setPropagationCount(Long propagationCount) {
		getCachedEntity().setProperty("propagationCount", propagationCount);
	}

	public Long getPropagationCount() {
		return (Long) getCachedEntity().getProperty("propagationCount");
	}

	// If this is set to true, a monster will spawn with the next tick. This is necessary to get the army propagation started because otherwise this entity will be deleted if no monsters that match this army's npcDefKey are found in the location.
	public void setSeed(Boolean seed) {
		getCachedEntity().setProperty("seed", seed);
	}

	public Boolean getSeed() {
		return (Boolean) getCachedEntity().getProperty("seed");
	}

	// The number of NPCs that are to spawn every tick. If this is a number between 0 and 1, a random number will determine if a spawn is going to take place or not. If this number is greater than 1, then that number of spawns will occur per tick (a tick is 10 minutes).
	public void setSpawnsPerTick(Double spawnsPerTick) {
		getCachedEntity().setProperty("spawnsPerTick", spawnsPerTick);
	}

	public Double getSpawnsPerTick() {
		return (Double) getCachedEntity().getProperty("spawnsPerTick");
	}

	// This is a unique ID that propagates with the NPCArmy entities as they move about the map. This makes it easier to select all the army entities that came from the same seed.
	public void setUniqueId(String uniqueId) {
		getCachedEntity().setProperty("uniqueId", uniqueId);
	}

	public String getUniqueId() {
		return (String) getCachedEntity().getProperty("uniqueId");
	}

}
