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

    public static final int NUMBER = 1, MAX = -1,LOCATION_P_CLASS = 2,LOCATION_NAME1 = 3,LOCATION_NAME2 = 4,
    LOCATION_SEX = 5, LOCATION_AGE = 6,LOCATION_SIB = 7,LOCATION_PARCH = 8,LOCATION_TICKET = 9,
    LOCATION_FARE = 10,LOCATION_CABIN = 11,LOCATION_EMBARKED = 12, LOCATION_SPLIT0 = 0,LOCATION_SPLIT1 = 1,
     SUBSTRING_LOCATION2 =2,SUBSTRING_LOCATION1 = 1;


    public boolean family (int number){
        if (number ==NUMBER) {
            return (this.sibSp+this.parch) >= number;
        }
            return (this.sibSp+this.parch) == number;
    }

    public boolean age(int min, int max) {
        if (max == MAX) {
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

                return (Integer.parseInt(this.passengerId)) <= Integer.parseInt(maxNumber);
            }
            if (Objects.equals(maxNumber, "") || Objects.equals(maxNumber, "0")) {
                return (Integer.parseInt(this.passengerId)) > (Integer.parseInt(minNumber));
            }
            else {
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
            this.pClass = Integer.valueOf(dataItem[LOCATION_P_CLASS]);
            this.name = getFormattedName(dataItem[LOCATION_NAME1] + ","+ dataItem[LOCATION_NAME2]);
            this.sex = dataItem[LOCATION_SEX];
            try {
                this.age = Integer.valueOf(dataItem[LOCATION_AGE]);
            } catch (Exception e){
                this.age = (Integer.valueOf("0")) ;
            }
            this.sibSp = Integer.valueOf(dataItem[LOCATION_SIB]);
            this.parch = Integer.valueOf(dataItem[LOCATION_PARCH]);
            this.ticket = dataItem[LOCATION_TICKET];
            this.fare = dataItem[LOCATION_FARE];
            this.cabin = dataItem[LOCATION_CABIN];
            this.embarked = dataItem[LOCATION_EMBARKED];
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
         lineData = lineData.substring(SUBSTRING_LOCATION1,lineData.length()-1);
         String [] split = lineData.split(",");
         String lastName = split[LOCATION_SPLIT0];
         String firstName = split[LOCATION_SPLIT1].substring(split[LOCATION_SPLIT1].indexOf("."));
         firstName = firstName.substring(SUBSTRING_LOCATION2);
         return firstName+" "+lastName;
     }
}
