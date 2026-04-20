package ds_mlbb_item;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TreeMLBBTutorial {

    static class ItemNode {
        String name;
        String note;
        List<ItemNode> children;

        ItemNode(String name, String note) {
            this.name = name;
            this.note = note;
            this.children = new ArrayList<>();
        }

        void addChild(ItemNode child) {
            children.add(child);
        }
    }

    static void printTree(ItemNode node, int level) {
        if (node == null) return;

        String indent = " ".repeat(level);
        System.out.println(indent + "- " + node.name + " -> " + node.note);

        for (ItemNode child : node.children) {
            printTree(child, level + 1);
        }
    }


    static void printAllBuildPaths(ItemNode node, List<String> path) {
        if (node == null) return;

        path.add(node.name);

        if (node.children.isEmpty()) {
            System.out.println(String.join(" -> ", path));
        } else {
            for (ItemNode child : node.children) {
                printAllBuildPaths(child, path);
            }
        }

        path.remove(path.size() - 1);
    }

    static int countNodes(ItemNode node) {
        if (node == null) return 0;
        int total = 1;
        for (ItemNode child : node.children) {
            total += countNodes(child);
        }
        return total;
    }

    static int countLeaves(ItemNode node) {
        if (node == null) return 0;
        if (node.children.isEmpty()) return 1;
        int total = 0;
        for (ItemNode child : node.children) {
            total += countLeaves(child);
        }
        return total;
    }

    static int height(ItemNode node) {
        if (node == null) return 0;
        if (node.children.isEmpty()) return 1;
        int maxChildHeight = 0;
        for (ItemNode child : node.children) {
            maxChildHeight = Math.max(maxChildHeight, height(child));
        }
        return 1 + maxChildHeight;
    }

    static boolean findPath(ItemNode node, String target, List<String> path) {
        if (node == null) return false;

        path.add(node.name);

        if (node.name.equalsIgnoreCase(target)) {
            return true;
        }

        for (ItemNode child : node.children) {
            if (findPath(child, target, path)) {
                return true;
            }
        }

        path.remove(path.size() - 1);
        return false; 
    }


    static int countItemOccurrences(ItemNode node, String itemName) {
        if (node == null) return 0;

        int count = node.name.equalsIgnoreCase(itemName) ? 1 : 0;

        for (ItemNode child : node.children) {
            count += countItemOccurrences(child, itemName);
        }
        return count;
    }


    static void printPathsEndingWith(ItemNode node, String targetLeaf, List<String> path) {
        if (node == null) return;

        path.add(node.name);

        if (node.children.isEmpty() && node.name.equalsIgnoreCase(targetLeaf)) {
            System.out.println(String.join(" -> ", path));
        } else {
            for (ItemNode child : node.children) {
                printPathsEndingWith(child, targetLeaf, path);
            }
        }

        path.remove(path.size() - 1);
    }


    static ItemNode fleetingTimeRecipe() {
        ItemNode fleetingTime = new ItemNode("Fleeting Time", "Item Jadi: Tambah HP & Pengurangan Cooldown setiap kali assist atau kill");
        ItemNode herosRing1 = new ItemNode("Hero's Ring", "Mentahan: +150 HP & +5% Pengurangan Cooldown");
        ItemNode herosRing2 = new ItemNode("Hero's Ring", "Mentahan: +150 HP & +5% Pengurangan Cooldown");
        ItemNode expertGloves = new ItemNode("Expert Gloves", "Mentahan: +30 Adaptive Attack");
        fleetingTime.addChild(herosRing1);
        fleetingTime.addChild(herosRing2);
        fleetingTime.addChild(expertGloves);
        return fleetingTime;
    }
    
    static ItemNode radiantArmorRecipe() {
        ItemNode radiantArmor = new ItemNode("Radiant Armor", "Item Jadi: Tahan magic damage beruntun");
        ItemNode silenceRobe = new ItemNode("Silence Robe", "Tier 2: + 23 Magic Defense &  23 HP");
        ItemNode magicResistCloak1 = new ItemNode("Magic Resist Cloak", "Mentahan: +14 Magic Defense");
        ItemNode magicResistCloak2 = new ItemNode("Magic Resist Cloak", "Mentahan: +14 Magic Defense");
        ItemNode healingNecklace = new ItemNode("Healing Necklace", "Mentahan: +4 Regen HP");
        ItemNode vitalityCrystal = new ItemNode("Vitality Crystal", "Mentahan: +230 HP");
        radiantArmor.addChild(silenceRobe);
        radiantArmor.addChild(magicResistCloak1);
        radiantArmor.addChild(healingNecklace);
        silenceRobe.addChild(magicResistCloak2);
        silenceRobe.addChild(vitalityCrystal);
        return radiantArmor;
    }

    static ItemNode chastisePauldronRecipe() {
        ItemNode chastisePauldron = new ItemNode("Chastise Pauldron", "Item Jadi: Mengurangi atack speed musuh");
        ItemNode steelLegplates = new ItemNode("Steel Legplates", "Tier 2: +35 Physical Defense");
        ItemNode aresBelt = new ItemNode("Ares Belt", "Tier 2: +600 HP");
        ItemNode leatherJerkin = new ItemNode("Leather Jerkin", "Mentahan: +14 Physical Defense");
        ItemNode vitalityCrystal = new ItemNode("Vitality Crystal", "Mentahan: +230 HP");
        chastisePauldron.addChild(steelLegplates);
        chastisePauldron.addChild(aresBelt);
        steelLegplates.addChild(leatherJerkin);
        aresBelt.addChild(vitalityCrystal);
        return chastisePauldron;
    }

    static ItemNode bruteForceBreastplateRecipe() {
        ItemNode bruteForceBreastplate = new ItemNode("Brute Force Breastplate", "Item Jadi: Tambah HP & Physical Defense setiap kali terkena damage");
        ItemNode aresBelt = new ItemNode("Ares Belt", "Tier 2: +600 HP");
        ItemNode herosRing = new ItemNode("Hero's Ring", "Mentahan: +150 HP & +5% Pengurangan Cooldown");
        ItemNode leatherJerkin = new ItemNode("Leather Jerkin", "Mentahan: +14 Physical Defense");
        ItemNode vitalityCrystal = new ItemNode("Vitality Crystal", "Mentahan: +230 HP");
        bruteForceBreastplate.addChild(aresBelt);
        bruteForceBreastplate.addChild(herosRing);
        bruteForceBreastplate.addChild(leatherJerkin);
        aresBelt.addChild(vitalityCrystal);
        return bruteForceBreastplate;
    }

    static ItemNode immortalityRecipe() {
        ItemNode immortality = new ItemNode("Immortality", "Item Jadi: Bangkit dari kematian");
        ItemNode aresBelt = new ItemNode("Ares Belt", "Tier 2: +600 HP");
        ItemNode vitalityCrystal1 = new ItemNode("Vitality Crystal", "Mentahan: +230 HP");
        ItemNode vitalityCrystal2 = new ItemNode("Vitality Crystal", "Mentahan: +230 HP");
        ItemNode leatherJerkin = new ItemNode("Leather Jerkin", "Mentahan: +14 Physical Defense");
        immortality.addChild(aresBelt);
        immortality.addChild(vitalityCrystal1);
        immortality.addChild(leatherJerkin);
        aresBelt.addChild(vitalityCrystal2);
        return immortality;
    }

    static ItemNode dominanceIceRecipe() {
        ItemNode dominanceIce = new ItemNode("Dominance Ice", "Item Jadi: Anti-heal");
        ItemNode blackIceShield = new ItemNode("Black Ice Shield", "Tier 2: +20 Physical & Magical Defense");
        ItemNode leatherJerkin1 = new ItemNode("Leather Jerkin", "Mentahan: +14 Physical Defense");
        ItemNode leatherJerkin2 = new ItemNode("Leather Jerkin", "Mentahan: +14 Physical Defense");
        ItemNode magicResistCloak1 = new ItemNode("Magic Resist Cloak", "Mentahan: +14 Magic Defense");
        ItemNode magicResistCloak2 = new ItemNode("Magic Resist Cloak", "Mentahan: +14 Magic Defense");
        dominanceIce.addChild(blackIceShield);
        dominanceIce.addChild(leatherJerkin1);
        dominanceIce.addChild(magicResistCloak1);
        blackIceShield.addChild(leatherJerkin2);
        blackIceShield.addChild(magicResistCloak2);
        return dominanceIce;
    }

    static ItemNode athenasShieldRecipe() {
        ItemNode athenasShield = new ItemNode("Athena's Shield", "Item Jadi: Shield anti-burst magic (Counter Mage)");
        ItemNode silenceRobe = new ItemNode("Silence Robe", "Tier 2: + 23 Magic Defense &  23 HP");
        ItemNode vitalityCrystal1 = new ItemNode("Vitality Crystal", "Mentahan: +230 HP");
        ItemNode vitalityCrystal2 = new ItemNode("Vitality Crystal", "Mentahan: +230 HP");
        ItemNode magicResistCloak = new ItemNode("Magic Resist Cloak", "Mentahan: +14 Magic Defense");
        athenasShield.addChild(silenceRobe);
        athenasShield.addChild(vitalityCrystal1);
        silenceRobe.addChild(vitalityCrystal2);
        silenceRobe.addChild(magicResistCloak);
        return athenasShield;
    }

    static ItemNode oracleRecipe() {
        ItemNode oracle = new ItemNode("Oracle", "Item Jadi: Tambah efek heal & shield");
        ItemNode herosRing1 = new ItemNode("Hero's Ring", "Mentahan: +150 HP & +5% Pengurangan Cooldown");
        ItemNode herosRing2 = new ItemNode("Hero's Ring", "Mentahan: +150 HP & +5% Pengurangan Cooldown");
        ItemNode vitalityCrystal = new ItemNode("Vitality Crystal", "Mentahan: +230 HP");
        oracle.addChild(herosRing1);
        oracle.addChild(herosRing2);
        oracle.addChild(vitalityCrystal);
        return oracle;
    }

    static ItemNode antiqueCuirassRecipe() {
        ItemNode antiqueCuirass = new ItemNode("Antique Cuirass", "Item Jadi: Kurangi physical attack musuh");
        ItemNode dreadnaughtArmor = new ItemNode("Dreadnaught Armor", "Tier 2: +30 Physical Defense");
        ItemNode aresBelt = new ItemNode("Ares Belt", "Tier 2: +600 HP");
        ItemNode leatherJerkin1 = new ItemNode("Leather Jerkin", "Mentahan: +14 Physical Defense");
        ItemNode leatherJerkin2 = new ItemNode("Leather Jerkin", "Mentahan: +14 Physical Defense");
        ItemNode vitalityCrystal = new ItemNode("Vitality Crystal", "Mentahan: +230 HP");
        antiqueCuirass.addChild(dreadnaughtArmor);
        antiqueCuirass.addChild(aresBelt);
        dreadnaughtArmor.addChild(leatherJerkin1);
        dreadnaughtArmor.addChild(leatherJerkin2);
        aresBelt.addChild(vitalityCrystal);
        return antiqueCuirass;
    }

    static ItemNode guardianHelmetRecipe() {
        ItemNode guardianHelmet = new ItemNode("Guardian Helmet", "Item Jadi: Regen HP tanpa recall");
        ItemNode aresBelt1 = new ItemNode("Ares Belt", "Tier 2: +600 HP");
        ItemNode aresBelt2 = new ItemNode("Ares Belt", "Tier 2: +600 HP");
        ItemNode aresBelt3 = new ItemNode("Ares Belt", "Tier 2: +600 HP");
        ItemNode vitalityCrystal1 = new ItemNode("Vitality Crystal", "Mentahan: +230 HP");
        ItemNode vitalityCrystal2 = new ItemNode("Vitality Crystal", "Mentahan: +230 HP");
        ItemNode vitalityCrystal3 = new ItemNode("Vitality Crystal", "Mentahan: +230 HP");
        guardianHelmet.addChild(aresBelt1);
        guardianHelmet.addChild(aresBelt2); 
        guardianHelmet.addChild(aresBelt3);
        aresBelt1.addChild(vitalityCrystal1);
        aresBelt2.addChild(vitalityCrystal2);
        aresBelt3.addChild(vitalityCrystal3);
        return guardianHelmet; 
    }

    static ItemNode cursedHelmetRecipe() {
        ItemNode cursedHelmet = new ItemNode("Cursed Helmet", "Item Jadi: Tambah HP & Magic Damage ke musuh sekitar setiap detik");
        ItemNode moltedEssence = new ItemNode("Molten Essence", "Tier 2: +540 HP & Magic Damage ke Lawan Sekitar");
        ItemNode aresBelt = new ItemNode("Ares Belt", "Tier 2: +600 HP");
        ItemNode magicResistCloak = new ItemNode("Magic Resist Cloak", "Mentahan: +14 Magic Defense");
        ItemNode vitalityCrystal1 = new ItemNode("Vitality Crystal", "Mentahan: +230 HP");
        ItemNode vitalityCrystal2 = new ItemNode("Vitality Crystal", "Mentahan: +230 HP");
        cursedHelmet.addChild(moltedEssence);
        cursedHelmet.addChild(aresBelt);
        cursedHelmet.addChild(magicResistCloak);
        moltedEssence.addChild(vitalityCrystal1);
        aresBelt.addChild(vitalityCrystal2);
        return cursedHelmet;
    }

    static ItemNode thunderBeltRecipe() {
        ItemNode thunderBelt = new ItemNode("Thunder Belt", "Item Jadi: Tambah HP & Magic Damage ke musuh sekitar setiap kali menggunakan skill");
        ItemNode aresBelt = new ItemNode("Ares Belt", "Tier 2: +600 HP");
        ItemNode leatherJerkin = new ItemNode("Leather Jerkin", "Mentahan: +14 Physical Defense");
        ItemNode magicResistCloak = new ItemNode("Magic Resist Cloak", "Mentahan: +14 Magic Defense");
        ItemNode vitalityCrystal = new ItemNode("Vitality Crystal", "Mentahan: +230 HP");
        thunderBelt.addChild(aresBelt);
        thunderBelt.addChild(leatherJerkin);
        thunderBelt.addChild(magicResistCloak);
        aresBelt.addChild(vitalityCrystal);
        return thunderBelt;
    }

    static ItemNode queensWingsRecipe() {
        ItemNode queensWings = new ItemNode("Queen's Wings", "Item Jadi: Tambah HP & Kurangi damage yang diterima saat HP di bawah 40%");
        ItemNode aresBelt = new ItemNode("Ares Belt", "Tier 2: +600 HP");
        ItemNode herosRing = new ItemNode("Hero's Ring", "Mentahan: +150 HP & +5% Pengurangan Cooldown");
        ItemNode expertGloves = new ItemNode("Expert Gloves", "Mentahan: +30 Adaptive Attack");
        ItemNode vitalityCrystal = new ItemNode("Vitality Crystal", "Mentahan: +230 HP");
        queensWings.addChild(aresBelt);
        queensWings.addChild(herosRing);
        queensWings.addChild(expertGloves);
        aresBelt.addChild(vitalityCrystal);
        return queensWings;
    }
    
    static ItemNode bladeArmorRecipe() {
        ItemNode bladeArmor = new ItemNode("Blade Armor", "Item Jadi: Pantulkan basic attack (Counter MM)");
        ItemNode steelLegplates = new ItemNode("Steel Legplates", "Tier 2: +35 Physical Defense");
        ItemNode leatherJerkin1 = new ItemNode("Leather Jerkin", "Mentahan: +14 Physical Defense");
        ItemNode leatherJerkin2 = new ItemNode("Leather Jerkin", "Mentahan: +14 Physical Defense");
        ItemNode leatherJerkin3 = new ItemNode("Leather Jerkin", "Mentahan: +14 Physical Defense");
        bladeArmor.addChild(steelLegplates);
        bladeArmor.addChild(leatherJerkin1);
        bladeArmor.addChild(leatherJerkin2);
        steelLegplates.addChild(leatherJerkin3);
        return bladeArmor;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ItemNode selectedItem = null;

        System.out.println("=== MLBB Item Build Tree Simulator ===");
        System.out.println("Pilih Item untuk dianalisis:");
        System.out.println("1. Fleeting Time");
        System.out.println("2. Radiant Armor");
        System.out.println("3. Chastise Pauldron");
        System.out.println("4. Brute Force Breastplate");
        System.out.println("5. Immortality");
        System.out.println("6. Dominance Ice");
        System.out.println("7. Athena's Shield");
        System.out.println("8. Oracle");
        System.out.println("9. Antique Cuirass");
        System.out.println("10. Guardian Helmet");
        System.out.println("11. Cursed Helmet");
        System.out.println("12. Thunder Belt");
        System.out.println("13. Queen's Wings");
        System.out.println("14. Blade Armor");
        System.out.print("Masukkan pilihan (1-14): ");
        
        int pilihan = scanner.nextInt();
        scanner.nextLine();

        switch (pilihan) {
            case 1: selectedItem = fleetingTimeRecipe(); break;
            case 2: selectedItem = radiantArmorRecipe(); break;
            case 3: selectedItem = chastisePauldronRecipe(); break;
            case 4: selectedItem = bruteForceBreastplateRecipe(); break;
            case 5: selectedItem = immortalityRecipe(); break;
            case 6: selectedItem = dominanceIceRecipe(); break;
            case 7: selectedItem = athenasShieldRecipe(); break;
            case 8: selectedItem = oracleRecipe(); break;
            case 9: selectedItem = antiqueCuirassRecipe(); break;
            case 10: selectedItem = guardianHelmetRecipe(); break;
            case 11: selectedItem = cursedHelmetRecipe(); break;
            case 12: selectedItem = thunderBeltRecipe(); break;
            case 13: selectedItem = queensWingsRecipe(); break;
            case 14: selectedItem = bladeArmorRecipe(); break;
            default:
                System.out.println("Pilihan tidak valid!");
                return;
        }

        System.out.println("\n" + "=".repeat(40));
        System.out.println("STRUKTUR ITEM: " + selectedItem.name.toUpperCase());
        System.out.println("=".repeat(40));

        System.out.println("\n[Visual Tree]");
        printTree(selectedItem, 0);

        System.out.println("\n[Statistik Tree]");
        System.out.println("Total Node (Semua Komponen): " + countNodes(selectedItem));
        System.out.println("Total Leaves (Item Mentahan Dasar): " + countLeaves(selectedItem));
        System.out.println("Tinggi Tree (Kedalaman Build): " + height(selectedItem));

        System.out.println("\n[Semua Jalur Build]");
        printAllBuildPaths(selectedItem, new ArrayList<>());


        System.out.print("\nMasukkan nama komponen yang ingin dicari jalurnya (misal: Vitality Crystal): ");
        String searchTarget = scanner.nextLine();
        List<String> foundPath = new ArrayList<>();
        if (findPath(selectedItem, searchTarget, foundPath)) {
            System.out.println("Item ditemukan! Jalur: " + String.join(" -> ", foundPath));
        } else {
            System.out.println("Item '" + searchTarget + "' tidak ditemukan dalam build ini.");
        }

        System.out.print("\nMasukkan nama item untuk hitung jumlah kemunculan (misal: Ares Belt): ");
        String countTarget = scanner.nextLine();
        int occurrences = countItemOccurrences(selectedItem, countTarget);
        System.out.println("Item '" + countTarget + "' muncul sebanyak: " + occurrences + " kali.");

        System.out.println("\n[Pencarian Jalur Berujung pada Item Tertentu]");
        System.out.print("Masukkan nama item mentahan akhir (misal: Leather Jerkin): ");
        String leafTarget = scanner.nextLine();
        System.out.println("Jalur yang berujung di " + leafTarget + ":");
        printPathsEndingWith(selectedItem, leafTarget, new ArrayList<>());

        System.out.println("\n=== Simulasi Selesai ===");
        scanner.close();
    }
}
