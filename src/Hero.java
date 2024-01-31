public class Hero {

    // properties

    public String name;
    public int hitPoints;

    // constructors

    public Hero(String name){

        this.name = name;
        hitPoints = 100;

    }

    // methods

    public String getName(){

        return name;

    }

    public int getHitPoints(){

        return hitPoints;

    }

    public String toString(){

        return "Hero{name='" + name + "', hitPoints=" + hitPoints + "}";

    }

    public void attack(Hero opponent){

        double num = Math.random();

        if(num < 0.5){

            opponent.hitPoints -= 10;

        } else {

            hitPoints -= 10;

        }

    }

    public void senzuBean(){

        hitPoints = 100;

    }

    private void fightUntilTheDeathHelper(Hero opponent){

        while(hitPoints > 0 && opponent.hitPoints > 0){

            attack(opponent);

        }

    }

    public String fightUntilTheDeath(Hero opponent){

        senzuBean();
        fightUntilTheDeathHelper(opponent);

        return name + ": " + hitPoints + "  " + opponent.name + ": " + opponent.hitPoints;

    }

    private int[] nFightsToTheDeathHelper(Hero opponent, int n){

        int[] a = new int[2];
        int m = 0;
        int q = 0;
        int i = 0;

        while(i < n){

            fightUntilTheDeathHelper(opponent);

            if(hitPoints <= 0){

                senzuBean();
                m++;
                a[1] = m;

            } else if (opponent.hitPoints <= 0){

                opponent.senzuBean();
                q++;
                a[0] = q;

            }

            i++;

        }


        return a;

    }

    public String nFightsToTheDeath(Hero opponent, int n){

        int[] array = nFightsToTheDeathHelper(opponent, n);

        String str = name + ": " + array[0] + " wins\n" + opponent.name + ": " + array[1] + " wins";

        if(array[0] == array[1]){

            str += "\nOMG! It was actually a draw!";

        } else if (array[0] > array[1]){

            str += "\n" + name + " wins!";

        } else {

            str += "\n" + opponent.name + " wins!";

        }

        return str;

    }

    public void dramaticFightToTheDeath(Hero opponent){

        senzuBean();
        fightUntilTheDeathHelper(opponent);

        while(hitPoints > 0 && opponent.hitPoints > 0){

            System.out.println(name + ": " + hitPoints + "  " + opponent.name + ": " + opponent.hitPoints);

            try{

                Thread.sleep(1000);

            } catch (InterruptedException e){

                e.printStackTrace();

            }


        }

        if(hitPoints <= 0){

            System.out.println(opponent.name + " wins!");

        } else if(opponent.hitPoints <= 0){

            System.out.println(name + " wins!");

        }

    }





}
