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

    public boolean stringContained ( String nameOfUser){
        if (!this.name.contains(nameOfUser)){
            return false;
        }
        return true;
    }
    public boolean amountOfBrothers (int number){
        return (this.sibSp == number);
    }



    public boolean rangeOfId (String minNumber,String maxNumber) {
        try {
            System.out.println(minNumber + " min");
            if (minNumber == null) {
                System.out.println("הגעתי");
                return (Integer.parseInt(this.passengerId)) <= Integer.parseInt(maxNumber);
            }
            if (maxNumber == null) {
                return (Integer.parseInt(this.passengerId)) > (Integer.parseInt(minNumber));
            }
            else {
                System.out.println("לפה");
                return (Integer.parseInt(this.passengerId)) >= Integer.parseInt(minNumber) && (Integer.parseInt(this.passengerId)) <= Integer.parseInt(maxNumber);
            }
        }catch (Exception e) {
            return false;
        }

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

    public void setPassengerId(String passenerId) {
        this.passengerId = passenerId;
    }

    public boolean isSurvived() {
        return survived;
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
            this.name = getFormattedName(dataItem[3] + dataItem[4]);
            this.sex = dataItem[5];
            this.age = Integer.valueOf(dataItem[6]);
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
                '}';
    }

    public String getFormattedName(String lineData){
         String [] dataItem = lineData.split("  ");
         for (int i=0; i< dataItem.length; i++) {
             String [] dataItemSplit= dataItem[i].split(" Mrs. ");
          //   System.out.println(dataItemSplit[i]+i );
         }
      //   System.out.println(dataItem[0]);
         return lineData;




     }
}
