package Exercise_01;

public class Architect {
    
    int code;
    String name,contract_condition,speciality,type_of_supervision, type_of_insurance;
    int number_of_works;

    public Architect(
        int code,
        String name,
        String contract_condition, 
        String speciality,
        String type_of_supervision,
        String type_of_insurance,
        int number_of_works
    ){
        this.code = code;
        this.name = name;
        this.contract_condition = contract_condition;
        this.speciality = speciality;
        this.type_of_supervision = type_of_supervision;
        this.number_of_works = number_of_works;
        this.type_of_insurance = type_of_insurance;
    }
    
    public double baseSalary(){
        if(contract_condition.equalsIgnoreCase("Estable") && type_of_supervision.equalsIgnoreCase("Obras")){
            return 4000;
        }
        
        if(contract_condition.equalsIgnoreCase("Estable") && type_of_supervision.equalsIgnoreCase("Vias")){
            return 6000;
        }
        
        if(contract_condition.equalsIgnoreCase("Contratado") && type_of_supervision.equalsIgnoreCase("Obras")){
            return 2000;
        }
        
        if(contract_condition.equalsIgnoreCase("Contratado") && type_of_supervision.equalsIgnoreCase("Vias")){
            return 4500;
        }
        
        return 0;
    }
    
    public double bonus(){
        if(speciality.equalsIgnoreCase("Estructuras")){
            return baseSalary() * 0.16;
        }
        
        if(speciality.equalsIgnoreCase("Recursos Hidricos")){
            return baseSalary() * 0.18;
        }
        
        if(speciality.equalsIgnoreCase("Ingenieria Vial")){
            return baseSalary() * 0.22;
        }
        
        return 0;
    }
    
    public double discounts(){
        if(type_of_insurance.equalsIgnoreCase("AFP")){
            return baseSalary()  * 0.15;
        }
        
        if(type_of_insurance.equalsIgnoreCase("SNP")){
            return baseSalary() * 0.8;
        }
        
        return 0;
    }
    
    public int mobility(){
        if(number_of_works < 17){
            return 300;
        }else if(number_of_works >= 18){
            return 600;
        }
        
        return 0;
    }
    
    public double grossSalary(){
        return baseSalary() + bonus();
    }
    
    public double netSalary(){
        return grossSalary() - discounts() + mobility();
    }
}
