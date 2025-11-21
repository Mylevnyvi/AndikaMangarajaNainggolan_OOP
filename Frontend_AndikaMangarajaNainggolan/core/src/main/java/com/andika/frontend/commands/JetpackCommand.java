package com.andika.frontend.commands;

import com.andika.frontend.Player;

public class JetpackCommand implements Command {

    private Player player;

    public JetpackCommand(Player player) {
        this.player = player;
    }

    @Override
    public void execute() {
        if (!player.isDead()) {
            player.fly();
        }
    }
}
