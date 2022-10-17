package de.dragonsroar.nes.data;

import com.google.gson.JsonObject;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
public class Slayer {
    @AllArgsConstructor @Getter
    public enum Type {
        ZOMBIE("zombie", new int[]{
                5, 15, 200, 1000, 5000, 20000, 100000, 400000, 1000000
        }),
        SPIDER("spider", new int[]{
                5, 25, 200, 1000, 5000, 20000, 100000, 400000, 1000000
        }),
        WOLF("wolf", new int[]{
                10, 30, 250, 1500, 5000, 20000, 100000, 400000, 1000000
        }),
        ENDERMAN("enderman", new int[]{
                10, 30, 250, 1500, 5000, 20000, 100000, 400000, 1000000
        }),
        BLAZE("blaze", new int[]{
                10, 30, 250, 1500, 5000, 20000, 100000, 400000, 1000000
        })
        ;
        private final String id;
        private int[] xpTable;
    }

    @Getter private int xp;
    @Getter private Type type;
    @Getter private boolean maxed;
    @Getter private int level;
    @Getter @Setter private int kills;
    @Getter private final List<Drop> drops = new ArrayList<>();

    public Slayer(Type type, int xp) {
        this.type = type;
        this.xp = xp;
    }

    public void setXp(int xp) {
        this.xp = xp;
        recalculate();
    }

    public void recalculate() {
        for(int i = 0; i < type.xpTable.length; ++i) {
            int xp = type.xpTable[i];
            if(this.xp < xp) {
                this.level = i;
                maxed = false;
                return;
            }
        }
        maxed = true;
        level = type.xpTable.length;
    }
}
