package de.dragonsroar.nes.data;

import com.google.gson.JsonObject;
import de.dragonsroar.nes.utils.API;
import lombok.Data;

@Data
public class PlayerData {
    private final String uuid, apiKey, profileID;
    private final Slayer zombieSlayer;
    private final Slayer spiderSlayer;
    private final Slayer wolfSlayer;
    private final Slayer endermanSlayer;
    private final Slayer blazeSlayer;

    private int combatXP;
    private int farmingXP;
    private int foragingXP;
    private int fishingXP;
    private int enchantingXP;
    private int miningXP;
    private int tamingXP;
    private int alchemyXP;

    public PlayerData(String uuid, String profileID, String apiKey) {
        JsonObject obj = API.get("https://api.hypixel.net/skyblock/profile?key=" + apiKey + "&uuid=" + uuid + "&profile=" + profileID).get("profile").getAsJsonObject().get("members").getAsJsonObject().get(uuid).getAsJsonObject();
        this.uuid = uuid; this.profileID = profileID; this.apiKey = apiKey;

        JsonObject slayers = obj.getAsJsonObject("slayer_bosses");
        if(obj.has("zombie") && obj.getAsJsonObject("zombie").has("xp")) {
            zombieSlayer = new Slayer(Slayer.Type.ZOMBIE, obj.getAsJsonObject("zombie").get("xp").getAsInt());
        } else {
            zombieSlayer = new Slayer(Slayer.Type.ZOMBIE, 0);
        }
        if(obj.has("spider") && obj.getAsJsonObject("spider").has("xp")) {
            spiderSlayer = new Slayer(Slayer.Type.SPIDER, obj.getAsJsonObject("spider").get("xp").getAsInt());
        } else {
            spiderSlayer = new Slayer(Slayer.Type.SPIDER, 0);
        }
        if(obj.has("wolf") && obj.getAsJsonObject("wolf").has("xp")) {
            wolfSlayer = new Slayer(Slayer.Type.WOLF, obj.getAsJsonObject("wolf").get("xp").getAsInt());
        } else {
            wolfSlayer = new Slayer(Slayer.Type.WOLF, 0);
        }
        if(obj.has("enderman") && obj.getAsJsonObject("enderman").has("xp")) {
            endermanSlayer = new Slayer(Slayer.Type.ENDERMAN, obj.getAsJsonObject("enderman").get("xp").getAsInt());
        } else {
            endermanSlayer = new Slayer(Slayer.Type.ENDERMAN, 0);
        }
        if(obj.has("blaze") && obj.getAsJsonObject("blaze").has("xp")) {
            blazeSlayer = new Slayer(Slayer.Type.BLAZE, obj.getAsJsonObject("blaze").get("xp").getAsInt());
        } else {
            blazeSlayer = new Slayer(Slayer.Type.BLAZE, 0);
        }

        combatXP = obj.get("experience_skill_combat").getAsInt();
        miningXP = obj.get("experience_skill_mining").getAsInt();
        farmingXP = obj.get("experience_skill_farming").getAsInt();
        fishingXP = obj.get("experience_skill_fishing").getAsInt();
        foragingXP = obj.get("experience_skill_foraging").getAsInt();
        tamingXP = obj.get("experience_skill_taming").getAsInt();
        alchemyXP = obj.get("experience_skill_alchemy").getAsInt();
        enchantingXP = obj.get("experience_skill_enchanting").getAsInt();
    }
}
