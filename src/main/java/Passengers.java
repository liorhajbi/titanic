import java.util.List;
import java.util.Objects;

public class Passengers {

    private String passengerId;
    private boolean survived;
    private int pClass;
    private String name;
    private String sex;
    private int age;
    private int sibSp;
    private int parch;
    private String ticket;
    private String fare;
    private String cabin;
    private String embarked;


    public boolean family (int number){
        if (number ==1) {
            return (this.sibSp+this.parch) >= number;
        }
            return (this.sibSp+this.parch) == number;
    }

    public boolean age(int min, int max) {
        if (max == -1) {
            return this.age >= min;
        }
        return this.age >= min && this.age <= max;

    }

    public boolean embarked (String embarked){
        if (this.embarked != null){
            return this.embarked.equals(embarked);
        }
        return false;
    }

    public boolean stringContained ( String nameOfUser){
        if (!this.name.contains(nameOfUser)){
            return false;
        }
        return true;
    }
    public boolean cabin ( String number){
        if (this.cabin== "" || this.cabin ==null){
            return false;
        }
        if (!this.cabin.contains(number)){
            return false;
        }
        return true;
    }

    public boolean ticket ( int number){
        if (!this.ticket.contains(String.valueOf(number))){
            return false;
        }
        return true;
    }

    public boolean parch(int number){
        return (this.parch == number);
    }

    public boolean sibSp(int number){
        return (this.sibSp == number);
    }


    public boolean rangeOfFare (String minNumber,String maxNumber) {
        try {
            if (Objects.equals(minNumber, "") || Objects.equals(minNumber, "0")) {
                return (Double.valueOf(this.fare) <= Double.valueOf(maxNumber));
            }
            if (Objects.equals(maxNumber, "") || Objects.equals(maxNumber, "0")) {
                return (Double.valueOf(this.fare) > Double.valueOf(minNumber));
            }
            else {
                return (Double.valueOf(this.fare)) >= Double.valueOf(minNumber) && (Double.valueOf(this.fare)) <= Double.valueOf(maxNumber);
            }
        } catch (NumberFormatException e){
            minNumber ="0";
            rangeOfFare(minNumber,maxNumber);
            System.out.println(e.getMessage());
        }
        return false;
    }



    public boolean rangeOfId (String minNumber,String maxNumber) {
            try {
            if (Objects.equals(minNumber, "") || Objects.equals(minNumber, "0")) {
                //  System.out.println("הגעתי");
                return (Integer.parseInt(this.passengerId)) <= Integer.parseInt(maxNumber);
            }
            if (Objects.equals(maxNumber, "") || Objects.equals(maxNumber, "0")) {
                return (Integer.parseInt(this.passengerId)) > (Integer.parseInt(minNumber));
            }
            else {
              //  System.out.println("לפה");
                return (Integer.parseInt(this.passengerId)) >= Integer.parseInt(minNumber) && (Integer.parseInt(this.passengerId)) <= Integer.parseInt(maxNumber);
            }
            } catch (NumberFormatException e){
                minNumber ="0";
                rangeOfId(minNumber,maxNumber);
                System.out.println(e.getMessage());
            }
            return false;
    }

    public boolean typeOfClass (int number){
        return this.getpClass() == number;
    }
    public boolean typeOfSex (String sex){
        return Objects.equals(this.getSex(), sex);
    }

    public String getPassengerId() {
        return passengerId;
    }

    public void setPassengerId(String passengerId) {
        this.passengerId = passengerId;
    }

    public boolean Survived() {
        return survived;
    }
    public boolean notSurvived() {
        return !survived;
    }

    public void setSurvived(boolean survived) {
        this.survived = survived;
    }

    public int getpClass() {
        return pClass;
    }

    public void setpClass(int pClass) {
        this.pClass = pClass;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getSibSp() {
        return sibSp;
    }

    public void setSibSp(int sibSp) {
        this.sibSp = sibSp;
    }

    public int getParch() {
        return parch;
    }

    public void setParch(int parch) {
        this.parch = parch;
    }

    public String getTicket() {
        return ticket;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket;
    }

    public String getFare() {
        return fare;
    }

    public void setFare(String fare) {
        this.fare = fare;
    }

    public String getCabin() {
        return cabin;
    }

    public void setCabin(String cabin) {
        this.cabin = cabin;
    }

    public String getEmbarked() {
        return embarked;
    }

    public void setEmbarked(String embarked) {
        this.embarked = embarked;
    }

    public Passengers (String lineData) {
        try {
            String[] dataItem = lineData.split(",");
            this.passengerId = (dataItem[0]);
            if (dataItem[1].equals("0")) {
                this.survived = false;
            } else {
                this.survived = true;
            }
            this.pClass = Integer.valueOf(dataItem[2]);
            this.name = getFormattedName(dataItem[3] + ","+ dataItem[4]);
            this.sex = dataItem[5];
            try {
                this.age = Integer.valueOf(dataItem[6]);
            } catch (Exception e){
                this.age = (Integer.valueOf("0")) ;
            }
            this.sibSp = Integer.valueOf(dataItem[7]);
            this.parch = Integer.valueOf(dataItem[8]);
            this.ticket = dataItem[9];
            this.fare = dataItem[10];
            this.cabin = dataItem[11];
            this.embarked = dataItem[12];
        }catch (Exception e){

        }
    }

    @Override
    public String toString() {
        return "Passengers{" +
                "passenerId=" + passengerId +
                ", survived=" + survived +
                ", pClass=" + pClass +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                ", sibSp=" + sibSp +
                ", parch=" + parch +
                ", ticket='" + ticket + '\'' +
                ", fare='" + fare + '\'' +
                ", cabin='" + cabin + '\'' +
                ", embarked='" + embarked + '\'' +
                '}' + "\n";
    }

    public String getFormattedName(String lineData){
         String name = "";
         lineData = lineData.substring(1,lineData.length()-1);
         String [] split = lineData.split(",");
         String lastName = split[0];
         String firstName = split[1].substring(split[1].indexOf("."));
         firstName = firstName.substring(2);
         return firstName+" "+lastName;
     }
}
