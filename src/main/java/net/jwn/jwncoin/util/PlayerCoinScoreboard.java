package net.jwn.jwncoin.util;

import net.minecraft.network.chat.Component;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.scores.Scoreboard;
import net.minecraft.world.scores.criteria.ObjectiveCriteria;
import net.neoforged.neoforge.event.server.ServerStartingEvent;

public class PlayerCoinScoreboard {
    public static void setScoreboard(ServerStartingEvent event) {
        MinecraftServer server = event.getServer();
        Scoreboard scoreboard = server.getScoreboard();

        String objectiveName = "coins";
        if (scoreboard.getObjective(objectiveName) == null) {
            scoreboard.addObjective(
                    objectiveName,                           // 내부 ID
                    ObjectiveCriteria.DUMMY,                 // 수동 조작
                    Component.literal("Coins"),         // 화면에 표시될 이름
                    ObjectiveCriteria.RenderType.INTEGER,    // 숫자로 표시
                    true,                                    // 자동 갱신 (보통 true)
                    null                                     // 기본 포맷 (천단위 쉼표 없음)
            );
        }
    }
}
