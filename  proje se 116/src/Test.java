import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Scanner;

public class Test {

    public static void main(String[] args) {
        Test test =new Test();
        int score=0;
        boolean boolean_1=true;
        Scanner scanner=new Scanner(System.in);
        ArrayList<Character> player = new ArrayList<Character>();
        ArrayList<Enemy> enemy_arraylist = new ArrayList<Enemy>();
        ArrayList<Item> droppedItems = new ArrayList<Item>();
        SecureRandom secureRandom=new SecureRandom();

        HardArmor hardArmor=new HardArmor(2,1,2);
        TowerShield towerShield=new TowerShield(3,2,1,2);

        MediumArmor mediumArmor=new MediumArmor(0.5,1,5);
        LongSword longSword=new LongSword(3,0.5, 1.0,1.5);

        SmallArmor smallArmor=new SmallArmor(1,1,2);
        WoodWand woodWand=new WoodWand(1,1,1,2);


        player.add(new Warrior(secureRandom.nextInt(6,10), secureRandom.nextInt(3,7), secureRandom.nextInt(1,5),mediumArmor,longSword));
        player.add(new Tank(secureRandom.nextInt(1,5), secureRandom.nextInt(6,10),secureRandom.nextInt(3,7),hardArmor,towerShield));
        player.add(new Healer(secureRandom.nextInt(3,7), secureRandom.nextInt(1,5),secureRandom.nextInt(6,10),smallArmor,woodWand));




        while(boolean_1){

            for(int Level=1;Character.AliveİnLevel>0;Level++) {
                for(int i =0;i<enemy_arraylist.size();i++) {
                    enemy_arraylist.removeAll(enemy_arraylist);
                }

                boolean boolean_2=true;
                for(int i =0;i<(droppedItems.size()-1);i++) {
                    droppedItems.remove(i);
                }
                while(Enemy.enemy_count<Math.pow(2,Level)) {
                    Weapon x = test.enemyWeaponSelectionRandom();
                    Enemy enemy = new Enemy(secureRandom.nextInt(1, 5), secureRandom.nextInt(1, 5),
                            secureRandom.nextInt(1, 5), mediumArmor, x);// weapon going to be added
                    enemy_arraylist.add(enemy);
                }

                for (;Enemy.enemy_count > 0;) {
                    System.out.println("You are on level " + Level);
                    System.out.println();

                    for (Character x : player) {
                        System.out.println(x.getName() + " is " + x.String_getis_Alive() + " and HP is " + x.getHp());
                    }
                    System.out.println("----------------");

                    System.out.println("Select a character of yours ");
                    Test.display(player);
                    int selected_character = (scanner.nextInt()-1);
                    Character y =player.get(selected_character);
                    test.characterActions(y, player,enemy_arraylist);

                    System.out.println("----------------");

                    System.out.println("Select an enemy:");
                    Test.display_e(enemy_arraylist);
                    int selected_enemy = (scanner.nextInt()-1);

                    System.out.println("----------------");

                    Test.attackOnLevel(player.get(selected_character),enemy_arraylist.get(selected_enemy),droppedItems,enemy_arraylist,player);
                    //Ennemy attack yapıcak önemli
                    System.out.println();

                    if(Enemy.enemy_count==0){
                        score=score + 5*enemy_arraylist.size();
                        Test.endOfLevelMenu(droppedItems,player);
                    }
                }
            }
            File file = new File("HighScore");
            try {

                if (!file.exists()) {
                    file.createNewFile();

                }
                PrintWriter pw = new PrintWriter(file);
                pw.println("OUR HIGHEST SCORE IS " + score);
                pw.close();
                System.out.println("Done");


            } catch (IOException e) {
                e.printStackTrace();

            }
            //The highscore will be printed int the code and the if player want to continue, he will restard. Don't forget to reset all of the variables such as level etc.
        }
    }

    public static void display(ArrayList<Character> tempForArrayCharacters){
        int i =1;
        for(Character x : tempForArrayCharacters){
            System.out.println(i +". is " + x.getName() + " and " + x.String_getis_Alive() + " and Hp is " + x.getHp());
            i++;
        }
    }
    public static void display_e(ArrayList<Enemy> tempForArrayEnemy){
        int i =1;
        for(Enemy x : tempForArrayEnemy){
            System.out.println(i +". is " + x.getName() + " and " + x.String_getis_Alive() + " and Hp is " + x.getHp());
            i++;
        }
    }

    public static void attackOnLevel(Character x, Character y,ArrayList<Item> z, ArrayList<Enemy> v,ArrayList<Character> n){
        Test test = new Test();
        int found_2;
        if(y.getHp() - x.Attack() <= 0){
            System.out.println(x.getName() + " made " + x.Attack() + " damage to " + y.getClass().getName());
            y.setHp(0);
            y.setAlive(false);
            y.setCanAttack(false);
            for(Character u: v){
                if(u.getCanAttack()){
                    if(Tank.isIsTankAlive()){
                        if(n.get(1).getInitialArmor().getProtection()==u.Attack()){
                            System.out.println("Enemy give 0 damage");
                        }
                        else if(n.get(1).getInitialArmor().getProtection()< u.Attack()){
                            n.get(1).setHp((n.get(1).getHp() + n.get(1).getInitialArmor().getProtection())-u.Attack());
                        }
                        if(n.get(1).getHp()<=0){
                            Tank.setIsTankAlive(false);
                            n.get(1).setHp(0);
                            Character.AliveİnLevel--;
                        }
                    }
                    else if(Warrior.isIsWarriorAlive()){
                        if(n.get(0).getInitialArmor().getProtection()==u.Attack()){
                            System.out.println("Enemy give 0 damage");
                        }
                        else if(n.get(0).getInitialArmor().getProtection()< u.Attack()){
                            n.get(0).setHp((n.get(0).getHp() + n.get(0).getInitialArmor().getProtection())-u.Attack());
                        }
                        if(n.get(0).getHp()<=0){
                            Warrior.setIsWarriorAlive(false);
                            n.get(0).setHp(0);
                            Character.AliveİnLevel--;
                        }
                    }
                    else{
                        if(n.get(2).getInitialArmor().getProtection()==u.Attack()){
                            System.out.println("Enemy give 0 damage");
                        }
                        else if(n.get(2).getInitialArmor().getProtection()< u.Attack()){
                            n.get(2).setHp((n.get(2).getHp() + n.get(2).getInitialArmor().getProtection())-u.Attack());
                        }
                        if(n.get(2).getHp()<=0){
                            Healer.setIsHealerAlive(false);
                            n.get(2).setHp(0);
                            Character.AliveİnLevel--;
                        }
                    }
                }
            }
            z.add(test.itemDrop());
            Enemy.enemy_count--;
        }
        else if(y.getHp() - x.Attack() > 0){
            y.setHp(y.getHp() - x.Attack());
            System.out.println(x.getName() + "gave" + x.Attack() + " damage to " + x.getClass().getName());

            for(Character u: v){
                if(u.getCanAttack()){
                    if(Tank.isIsTankAlive()){
                        n.get(1).setHp(n.get(1).getHp()-u.Attack());
                        if(n.get(1).getHp()<=0){
                            Tank.setIsTankAlive(false);
                        }
                    }
                    else if(Warrior.isIsWarriorAlive()){
                        n.get(0).setHp(n.get(0).getHp()-u.Attack());
                        if(n.get(0).getHp()<=0){
                            Warrior.setIsWarriorAlive(false);
                        }
                    }
                    else{
                        n.get(2).setHp(n.get(2).getHp()-u.Attack());
                        if(n.get(2).getHp()<=0){
                            Healer.setIsHealerAlive(false);
                        }
                    }
                }
            }
        }
    }

    public static void endOfLevelMenu(ArrayList<Item> temp_droppedItems, ArrayList<Character> temp_player) {
        boolean boolean_2 = true;
        Scanner scanner = new Scanner(System.in);
        while (boolean_2) {
            System.out.println("--Menu--");
            System.out.println("Press 1 to Examine");
            System.out.println("Press 2 to see ınventory of character");
            System.out.println("Press 3 to wield the weapon");
            System.out.println("Press 4 to wear the armor");
            System.out.println("Press 5 to quit from menu");
            int tempNumber = scanner.nextInt();

            switch (tempNumber) {
                case (1):
                    for (Item x : temp_droppedItems) {
                        x.PrintInfo();
                    }
                    System.out.println();
                    break;
                case (2):
                    display(temp_player);
                    System.out.println("Choose the character you want to see inventory of");
                    int z = scanner.nextInt();
                    if(temp_player.get(z).ınventory.isEmpty()){
                        System.out.println("The ınventory of the character is empty");
                        break;
                    }
                    else{
                        temp_player.get(z).ShowInventory();
                        break;
                    }
                case (3):
                    System.out.println("Choose the character");
                    display(temp_player);
                    int x = scanner.nextInt();
                    System.out.println("Press 1 to wield an ıtem from the ınventory of the character");
                    System.out.println("Press 2 to wield an ıtem from the ıtems dropped on the level");
                    switch (scanner.nextInt()) {
                        case (1):
                            temp_player.get(x).ShowInventory();
                            System.out.println("Enter the name of the weapon you want to wield");
                            String y = scanner.nextLine();

                            if (temp_player.get(x).ınventory.equals(y)) {
                                int c = temp_player.get(x).ınventory.indexOf(y);
                                temp_player.get(x).Wield((Weapon) temp_player.get(x).ınventory.get(c));
                            } else {
                                System.out.println("You entered ıtem name wrong");
                            }
                            break;
                        case (2):
                            for (Item v : temp_droppedItems) { //we need to add a try catch here because it crashes the ınventory of character is 0
                                v.PrintInfo();
                                System.out.println("Enter the name of the ıtem you want to wield");
                                String b = scanner.nextLine();

                                if (temp_droppedItems.equals(b)) {
                                    int ç = temp_droppedItems.indexOf(b);
                                    temp_player.get(x).Wield((Weapon) temp_droppedItems.get(ç));
                                } else {
                                    System.out.println("You entered ıtem name wrong");
                                }
                                break;
                            }
                    }
                    break;
                case (4):
                    System.out.println("Choose the character");
                    display(temp_player);
                    int ü = scanner.nextInt();
                    System.out.println("Press 1 to wear an ıtem from the ınventory of the character");
                    System.out.println("Press 2 to wear an ıtem from the ıtems dropped on the level");
                    switch (scanner.nextInt()) {
                        case (1):
                            temp_player.get(ü).ShowInventory();
                            System.out.println("Enter the name of the armor you want to wield");
                            String ğ = scanner.nextLine();

                            if (temp_player.get(ü).ınventory.equals(ğ) | ğ.getClass().getName() != "Item" | ğ.getClass().getName() != "Armor") {
                                int p = temp_player.get(ü).ınventory.indexOf(ğ);
                                temp_player.get(ü).Wield((Weapon) temp_player.get(ü).ınventory.get(p));
                            } else {
                                System.out.println("You entered ıtem name wrong");
                            }
                            break;
                        case (2):
                            for (Item v : temp_droppedItems) {
                                v.PrintInfo();
                                System.out.println("Enter the name of the armor you want to wield");
                                String o = scanner.nextLine();

                                if (temp_droppedItems.equals(o) | o.getClass().getName() != "Item" | o.getClass().getName() != "Armor") {
                                    int s = temp_droppedItems.indexOf(o);
                                    temp_player.get(ü).Wield((Weapon) temp_droppedItems.get(s));
                                } else {
                                    System.out.println("You entered ıtem name wrong");
                                }
                                break;
                            }
                    }
                    break;
                case (5):
                    boolean_2 = false;
                    break;
            }
        }
    }

    public Item itemDrop(){
        SecureRandom secureRandom =new SecureRandom();
        int x = secureRandom.nextInt(0,100);
        if(x<80|x>=0){
            int y = secureRandom.nextInt(0,3);
            switch (y){
                case 1:
                    ShortSword sword =new ShortSword(secureRandom.nextInt(2,3), secureRandom.nextDouble(0.3,0.5),secureRandom.nextDouble(0.2,3.0), secureRandom.nextDouble(0.3,0.5) );
                    return sword;
                case 2:
                    Scimitar scimitar = new Scimitar(secureRandom.nextInt(2,4), secureRandom.nextDouble(0.5,1),secureRandom.nextDouble(0.4,4.0), secureRandom.nextDouble(0.5,1));
                    return scimitar;
                case 3:
                    LongSword longSword = new LongSword(secureRandom.nextInt(3,4), secureRandom.nextDouble(0.7,1.2),secureRandom.nextDouble(0.6,6.0), secureRandom.nextDouble(1,1.5));
                    return longSword;
            }
        }
        else if(x<90|x>=80){
            int y = secureRandom.nextInt(0,3);
            switch (y){
                case 1:
                    BucklerShield bucklerShield=new BucklerShield(secureRandom.nextInt(2,3), secureRandom.nextDouble(0.5,0.7),secureRandom.nextDouble(0.2,3.0), secureRandom.nextDouble(0.5,1));
                    return bucklerShield;
                case 2:
                    SmallShield smallShield = new SmallShield(secureRandom.nextInt(2,4), secureRandom.nextDouble(0.7,1),secureRandom.nextDouble(0.4,4.0), secureRandom.nextDouble(1,1.5));
                    return smallShield;
                case 3:
                    TowerShield towerShield = new TowerShield(secureRandom.nextInt(3,4), secureRandom.nextDouble(1,2),secureRandom.nextDouble(0.6,6.0), secureRandom.nextDouble(1.5,2.5));
                    return towerShield;
            }
        }
        else if(x<=99|x>=90){
            int y = secureRandom.nextInt(0,3);
            switch (y){
                case 1:
                    BoneWand boneWand=new BoneWand(secureRandom.nextInt(2,3), secureRandom.nextDouble(0.3,0.6),secureRandom.nextDouble(0.2,3.0), 1);
                    return boneWand;
                case 2:
                    WoodWand woodWand=new WoodWand(secureRandom.nextInt(3,5), secureRandom.nextDouble(0.7,1),secureRandom.nextDouble(1.5,5.0), secureRandom.nextInt(1,3));
                    return woodWand;
            }
        }
        return null;
    }

    public void characterActions(Character x,ArrayList<Character>y,ArrayList<Enemy>p){
        Scanner scanner=new Scanner(System.in);
        if(x.getName().equals("Warrior")){
            System.out.println("Do you want to use special action of that character?");
            System.out.println("write yes or no");
            String ğ =scanner.next();
            if(ğ.toLowerCase().replaceAll(" ","").equals("yes")){
                ((Warrior) x).getInitialWeapon().keepAwayEnemies(p);
            }
            else{
                System.out.println("special action is not used");
            }
        }

        if(x.getName().equals("Healer")){
            System.out.println("Do you want to use special action of that character?");
            System.out.println("write yes or no");
            String ğ =scanner.next();
            if(ğ.toLowerCase().replaceAll(" ","").equals("yes")){
                System.out.println("choose the character you want to heal");
                display(y);
                int u = (scanner.nextInt()-1);
                Character o =y.get(u);
                ((Healer) x).getInitialWeapon().heal(((Healer) x),o);
            }
            else{
                System.out.println("special action is not used");
            }
        }

        if(x.getName().equals("Tank")){
            System.out.println("Do you want to use special action of that character?");
            System.out.println("write yes or no");
            String ğ =scanner.next();
            if(ğ.toLowerCase().replaceAll(" ","").equals("yes")){
                ((Tank) x).getInitialWeapon().stunEnemies(p);
            }
            else{
                System.out.println("special action is not used");
            }
        }
    }

    public Weapon enemyWeaponSelectionRandom(){
        SecureRandom secureRandom =new SecureRandom();
        int x = secureRandom.nextInt(0,100);
        if(x<80|x>=0){
            int y = secureRandom.nextInt(0,3);
            switch (y){
                case 1:
                    ShortSword sword =new ShortSword(secureRandom.nextInt(2,3), secureRandom.nextDouble(0.3,0.5),secureRandom.nextDouble(0.2,3.0), secureRandom.nextDouble(0.3,0.5) );
                    return sword;
                case 2:
                    Scimitar scimitar = new Scimitar(secureRandom.nextInt(2,4), secureRandom.nextDouble(0.5,1),secureRandom.nextDouble(0.4,4.0), secureRandom.nextDouble(0.5,1));
                    return scimitar;
                case 3:
                    LongSword longSword = new LongSword(secureRandom.nextInt(3,4), secureRandom.nextDouble(0.7,1.2),secureRandom.nextDouble(0.6,6.0), secureRandom.nextDouble(1,1.5));
                    return longSword;
            }
        }
        else if(x<90|x>=80){
            int y = secureRandom.nextInt(0,3);
            switch (y){
                case 1:
                    BucklerShield bucklerShield=new BucklerShield(secureRandom.nextInt(2,3), secureRandom.nextDouble(0.5,0.7),secureRandom.nextDouble(0.2,3.0), secureRandom.nextDouble(0.5,1));
                    return bucklerShield;
                case 2:
                    SmallShield smallShield = new SmallShield(secureRandom.nextInt(2,4), secureRandom.nextDouble(0.7,1),secureRandom.nextDouble(0.4,4.0), secureRandom.nextDouble(1,1.5));
                    return smallShield;
                case 3:
                    TowerShield towerShield = new TowerShield(secureRandom.nextInt(3,4), secureRandom.nextDouble(1,2),secureRandom.nextDouble(0.6,6.0), secureRandom.nextDouble(1.5,2.5));
                    return towerShield;
            }
        }
        else if(x<=99|x>=90){
            int y = secureRandom.nextInt(0,3);
            switch (y){
                case 1:
                    BoneWand boneWand=new BoneWand(secureRandom.nextInt(2,3), secureRandom.nextDouble(0.3,0.6),secureRandom.nextDouble(0.2,3.0), 1);
                    return boneWand;
                case 2:
                    WoodWand woodWand=new WoodWand(secureRandom.nextInt(3,5), secureRandom.nextDouble(0.7,1),secureRandom.nextDouble(1.5,5.0), secureRandom.nextInt(1,3));
                    return woodWand;
            }
        }
        return null;
    }


}