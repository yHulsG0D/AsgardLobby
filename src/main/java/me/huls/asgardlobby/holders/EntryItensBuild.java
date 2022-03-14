package me.huls.asgardlobby.holders;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class EntryItensBuild implements Listener {

    public static ItemStack serverselector(Player p) {
        ItemStack selectoritem = new ItemStack(Material.WATCH, 1);
        ItemMeta meta = selectoritem.getItemMeta();

        meta.setDisplayName("§eSeletor de servidores");
        ArrayList<String> lore = new ArrayList<>();
        lore.add("§7Selecione o servidor");
        lore.add("§7que você deseja entrar.");
        meta.setLore(lore);
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        selectoritem.setItemMeta(meta);
        return selectoritem;
    }

    public static ItemStack infos(Player p) {
        ItemStack infositem = new ItemStack(Material.BOOK_AND_QUILL, 1);
        ItemMeta meta = infositem.getItemMeta();

        meta.setDisplayName("§eInformações");
        ArrayList<String> lore = new ArrayList<>();
        lore.add("§7Confira algumas informações");
        lore.add("§7oficiais do servidor.");
        meta.setLore(lore);
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        infositem.setItemMeta(meta);
        return infositem;
    }

    public static ItemStack pvp(Player p) {
        ItemStack pvpitem = new ItemStack(Material.GOLD_SWORD, 1);
        ItemMeta meta = pvpitem.getItemMeta();

        meta.setDisplayName("§ePVP");
        ArrayList<String> lore = new ArrayList<>();
        lore.add("§7Clique para batalhar");
        lore.add("§7com outros jogadores");
        meta.setLore(lore);
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        pvpitem.setItemMeta(meta);
        return pvpitem;
    }
}