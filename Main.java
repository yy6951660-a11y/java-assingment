// Source code is decompiled from a .class file using FernFlower decompiler (from Intellij IDEA).
class PayrollAccount {
   private double basicSalary;
   private double bonus;

   public PayrollAccount(double var1) {
      if (var1 < (double)0.0F) {
         System.out.println("Warning: Negative basic salary. Starting at Rs 0.0");
         this.basicSalary = (double)0.0F;
      } else {
         this.basicSalary = var1;
      }

      this.bonus = (double)0.0F;
   }

   public void creditBonus(double var1) {
      if (var1 <= (double)0.0F) {
         System.out.println("Bonus rejected: amount must be greater than 0");
      } else {
         this.bonus += var1;
         System.out.println("Bonus credited: Rs " + var1);
      }

   }

   public void deductTax(double var1) {
      if (!(var1 < (double)0.0F) && !(var1 > (double)100.0F)) {
         this.basicSalary -= this.basicSalary * var1 / (double)100.0F;
         System.out.println("Tax deducted: " + var1 + "%");
      } else {
         System.out.println("Tax rejected: percentage must be between 0 and 100");
      }

   }

   public double getNetSalary() {
      return this.basicSalary + this.bonus;
   }
}
