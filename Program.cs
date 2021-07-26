using System;

namespace C__Learning_Programs
{ 

    class Player
    {
      public string name;
      public string weapon;
      private int health;
      private int shield;
      private float strength;
      private int ammo;
      private int random;
      public bool isAlive;

      Random num = new Random();

      public Player(string _name, string _weapon)
      {
        name = _name;
        weapon = _weapon;
        health = 5;
        shield = 1;
        strength = 1f;
        ammo = 10;
        isAlive = true;
      }

     public void Shoot()
     {
       if (ammo > 0)
       {
         Console.WriteLine("\n" + name + " has decided to fire their " + weapon);
         ammo--;
         strength += 0.1f;
         random = num.Next(1, 11);
         if (random <= 5)
         {
          Console.WriteLine(name + " has taken some damage from the enemy");
          random = num.Next(0, 2);
           if (random == 0)
           {
             health--;
             strength -= 0.5f;
           }else if (random != 0 && shield == 0){
             health--;
           }else{
             shield--;
           }
         }else{
            Console.WriteLine(name + " has gotten away unscaved!");
            strength += 0.5f;
         }
       }
       else{
         Console.WriteLine("\n" + name + " is out of ammo, looks like it's time to regen!");
       }
     }

     public void WeaponChange(string _weapon)
     {
      Console.WriteLine("\nHero has switched from " + weapon + " to " + _weapon);
      weapon = _weapon;
      ammo = 10;
     }

     public void Regen()
     {
      Console.WriteLine("\n" + name + " has decided to regenerate some health");
      health++;
      strength += 2.2f;
      ammo = 10;
     }

     public void CheckStats()
     {
       Console.WriteLine("\nHealth: " + health);
       Console.WriteLine("Shield: " + shield);
       Console.WriteLine("Ammo: " + ammo);
       Console.WriteLine("Strength: " + strength);
       Console.WriteLine("Weapon: " + weapon);
     }

     public bool HealthCheck()
     {
       if (health > 0)
       {
         return true;
       }
       else
       {
         return false;
       }
     }

    }

    class Program
    {
       
        static void Main(string[] args)
        {

         string nameChoice;
         string weaponChoice;
         string answer;
    
         Console.WriteLine("Lets Create A Player!\n");
         Console.WriteLine("First I'm gonna need a name: ");
         nameChoice = Console.ReadLine();
         Console.WriteLine("\nNext I'm gonna need a weapon: ");
         weaponChoice = Console.ReadLine();
         Console.WriteLine("Perfect! Now let's play a game!\n\n");
 
         Player p1 = new Player(nameChoice, weaponChoice);

         while (p1.HealthCheck() == true)
         {

          Console.WriteLine("\nWould you like to a(attack an enemy), b(regen), c(change weapon), or d(check stats)");
          answer = Console.ReadLine();
  
          if (answer == "a")
          {
            p1.Shoot();
            answer = "";
          }else if(answer == "b"){
            p1.Regen();
            answer = "";
          }else if(answer == "c"){
            string newWeapon = "";
            Console.WriteLine("What weapon would you like to change to? ");
            newWeapon = Console.ReadLine();
            p1.WeaponChange(newWeapon);
          }else if(answer == "d"){
            p1.CheckStats();
            answer = "";
          }
         }

         Console.WriteLine("\nIt's been a good run, but our hero has passed away");
         Console.WriteLine("Here are their final stats: ");
         p1.CheckStats();
         
         Console.ReadKey();
        }
    }
}
