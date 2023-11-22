/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

//DAVIN WAHYU WARDANA
//6706223003
//D3IF-4603

import java.util.ArrayList;
import java.util.List;

class Equipment {
    private String type;
    private String name;
    private String state;

    public Equipment(String type, String name, String state) {
        this.type = type;
        this.name = name;
        this.state = state;
    }

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public String getState() {
        return state;
    }
}

class Skill {
    private String type;
    private String name;
    private String effect;
    private int power;

    public Skill(String type, String name, String effect, int power) {
        this.type = type;
        this.name = name;
        this.effect = effect;
        this.power = power;
    }

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public String getEffect() {
        return effect;
    }

    public int getPower() {
        return power;
    }
}

class Chara {
    private String name;
    private String race;
    private String job;
    private List<Equipment> equipments;
    private List<Skill> skills;

    public Chara(String name, String race, String job) {
        this.name = name;
        this.race = race;
        this.job = job;
        this.equipments = new ArrayList<>();
        this.skills = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getRace() {
        return race;
    }

    public String getJob() {
        return job;
    }

    public void addEquipment(String type, String name, String state) {
        Equipment equipment = new Equipment(type, name, state);
        equipments.add(equipment);
    }

    public void addSkill(String type, String name, String effect, int power) {
        Skill skill = new Skill(type, name, effect, power);
        skills.add(skill);
    }

    public List<Equipment> getEquipments() {
        return equipments;
    }

    public List<Skill> getSkills() {
        return skills;
    }
}

class Event {
    private String name;
    private String date;
    private String location;
    private List<Chara> charas;

    public Event(String name, String date, String location) {
        this.name = name;
        this.date = date;
        this.location = location;
        this.charas = new ArrayList<>();
    }

    public void charaJoin(Chara chara) {
        charas.add(chara);
    }


    public void showChara() {
    int charaCount = 1;
    for (Chara chara : charas) {
        System.out.println("Chara " + charaCount + ", chara name: " + chara.getName());
        System.out.println("Chara Bio:");
        System.out.println("Nama: " + chara.getName() + ", Race: " + chara.getRace() + ", Job: " + chara.getJob());

        System.out.println("Equipment:");
        for (Equipment equipment : chara.getEquipments()) {
            System.out.println("type: " + equipment.getType() + "\nname: " + equipment.getName() + "\nstate: " + equipment.getState());
        }

        System.out.println("Skill:");
        for (Skill skill : chara.getSkills()) {
            System.out.println("type: " + skill.getType() + "\nname: " + skill.getName() + "\nefek: " + skill.getEffect() + "\nserangan (+/-): " + skill.getPower());
        }

        charaCount++;
    }
}

    public String getName() {
        return name;
    }
    public List<Chara> getCharas() {
        return charas;
    }
}

class Player {
    private String playerName;
    private List<Chara> charas;

    public Player(String playerName) {
        this.playerName = playerName;
        this.charas = new ArrayList<>();
    }

    public void setCharas(Chara chara) {
        charas.add(chara);
    }

    public String getPlayerName() {
        return playerName;
    }

    public List<Chara> getCharas() {
        return charas;
    }
}
/**
 *
 * @author user
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Player player = new Player("Sweet Maccaroon");

        Chara chara1 = new Chara("To the top", "Human", "Knight");
        chara1.addEquipment("Clothes", "iron armor", "Defense +10");
        chara1.addEquipment("Weapon", "Iron Blade", "Attack +10");
        chara1.addSkill("Attack", "Double slash", "-", 10);

        Chara chara2 = new Chara("Summer breeze", "Elf", "Wizard");
        chara2.addEquipment("Hat", "Witch Hat", "Magic +15");
        chara2.addSkill("Magic", "Fireball", "Fire damage", 20);

        player.setCharas(chara1);
        player.setCharas(chara2);

        System.out.println("Player " + player.getPlayerName() + " memiliki " + player.getCharas().size() + " chara:");
        int charaCount = 1;
        for (Chara chara : player.getCharas()) {
            System.out.println("\nChara " + charaCount + ", chara name: " + chara.getName());
            System.out.println("Data Chara:");
            System.out.println("Chara Bio:");
            System.out.println("Nama: " + chara.getName());
            System.out.println("Race: " + chara.getRace());
            System.out.println("Job: " + chara.getJob());

            System.out.println("Equipment:");
            for (Equipment equipment : chara.getEquipments()) {
                System.out.println("- " + equipment.getName() + " (" + equipment.getType() + ", " + equipment.getState() + ")");
            }

            System.out.println("Skill:");
            for (Skill skill : chara.getSkills()) {
                System.out.println("- " + skill.getName() + " (" + skill.getType() + ", " + skill.getEffect() + ", " + skill.getPower() + ")");
            }

            charaCount++;
        }

        Event event1 = new Event("Ladang Bunga Maut", "11 - 12 November 2023", "South village manor");
        event1.charaJoin(chara1);
        event1.charaJoin(chara2);

        System.out.println("\nChara yang mengikuti event " + event1.getName() + ":");
        int eventCharaCount = 1;
        for (Chara chara : event1.getCharas()) {
            System.out.println("- Chara " + chara.getName() + ", race: " + chara.getRace() + ", job: " + chara.getJob());
            eventCharaCount++;
        }
    }
}