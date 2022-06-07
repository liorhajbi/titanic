import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MainPanel extends JPanel {
    private JComboBox<String> survivedComboBox;
    private JComboBox<String> sexSurvived;
    private JComboBox<String> embarkedSurvived;
    private ImageIcon titanic;


    private List <Passengers> passengersList;
    private JTextField minId;
    private JTextField maxId;
    private JTextField minFare;
    private JTextField maxFare;
    private JLabel minFareLabel;
    private JLabel maxFareLabel;
    private JTextField subStringName;
    private JTextField sibSp;
    private JTextField parch;
    private JTextField ticket;
    private JTextField cabin;
    private JLabel cabinLabel;
    private JLabel ticketLabel;
    private JLabel sibSpLabel;
    private JLabel subStringOfName;
    private JLabel sex;
    private JLabel parchLabel;
    private JLabel embarked;
    private JLabel summary;
    private JLabel fare;
    private JLabel id;
    private int number = 1;
    private JButton submit;
    private JButton statistic;

    public static final int FONT_SIZE = 20;
    public static final int X_OF_RANG_LABEL = 70 ,Y_OF_SURVIVED_LABEL = 10,  Y_OF_LABELS = 40,  WIDTH_OF_LABEL = 30 , HEIGHT_OF_LABEL = 20,
    NAME_X = 30, Y = 140,WIDTH = 120 ,HEIGHT = 40, SIB_SP_X = 30, Y_LOCATION = 200, X_LOCATION = 300,X = 190, LABELS_Y = 260,ID_Y = 80,
    X_LABELS = 60, FARE_Y = 370, MIN_MAX_FARE_Y = 330, ID_LABEL_Y = 90, X_MIN_FARE = 10, EMBARKED_Y = 300, BUTTON_SIZE1= 450
    ,BUTTON_SIZE2 = 100, SUMMARY_X = 80,SUMMARY_Y = 450, SUMMARY_WIDTH = 500, STATISTIC_X = 70, STATISTIC_Y = 500, STATISTIC_WIDTH = 200,
    NO_SORT = -1,MIN_AGE1 = 0,MIN_AGE2 = 11,MIN_AGE3 = 21,MIN_AGE4 = 31,MIN_AGE5 = 41, MIN_AGE6 = 51,MAX_AGE1 = 10,MAX_AGE2 = 20,
    MAX_AGE3 = 30, MAX_AGE4 = 40, MAX_AGE5 = 50, MAX_AGE6 = -1, TYPE_OF_CLASS1 = 1, TYPE_OF_CLASS2 = 2,TYPE_OF_CLASS3 = 3,
    BACKGROUND_X_Y = 0, BACKGROUND_WIDTH = 700, BACKGROUND_HEIGHT = 600;



    public MainPanel (int x, int y, int width, int height) {
        File file = new File(Constants.PATH_TO_DATA_FILE); //this is the path to the data file
        try {
            passengersList = new ArrayList<>();
            Scanner scanner = new Scanner(file);
            int i=0;
            while (scanner.hasNextLine()){
               String passenger = scanner.nextLine();
                if (i!=0){
                    Passengers passengers = new Passengers(passenger);
                    passengersList.add(passengers);

                }
                i++;
            }
                 this.titanic = new ImageIcon("titanic.jpg");


        } catch (FileNotFoundException e){
            e.printStackTrace();

        }
        this.setLayout(null);
        this.setBounds(x, y + Constants.MARGIN_FROM_TOP, width, height);
        JLabel survivedLabel = new JLabel(" class: ");
        survivedLabel.setBounds(x + Constants.MARGIN_FROM_LEFT, y+Y_OF_SURVIVED_LABEL, Constants.LABEL_WIDTH, Constants.LABEL_HEIGHT);
        survivedLabel.setForeground(Color.white);
        this.add(survivedLabel);
        JLabel minRangeLabel = new JLabel("max: ");
        minRangeLabel.setFont(new Font("TimesRoman", Font.PLAIN, FONT_SIZE));
        minRangeLabel.setForeground(Color.white);
        minRangeLabel.setBounds(survivedLabel.getX() + survivedLabel.getWidth()+X_OF_RANG_LABEL, survivedLabel.getY()+Y_OF_LABELS, Constants.COMBO_BOX_WIDTH-WIDTH_OF_LABEL, HEIGHT_OF_LABEL+Constants.COMBO_BOX_HEIGHT);
        this.add(minRangeLabel);
        this.subStringName = new JTextField();
        this.subStringName.setBounds(survivedLabel.getX() + survivedLabel.getWidth()+NAME_X,survivedLabel.getY()+Y,Constants.COMBO_BOX_WIDTH-WIDTH_OF_LABEL, HEIGHT_OF_LABEL+Constants.COMBO_BOX_HEIGHT);
        add(subStringName);
        this.subStringOfName = new JLabel("name:");
        this.subStringOfName.setBounds(survivedLabel.getX(),subStringName.getY(),WIDTH,HEIGHT);
        subStringOfName.setFont(new Font("TimesRoman", Font.PLAIN, FONT_SIZE));
        subStringOfName.setForeground(Color.white);
        add(subStringOfName);
        this.sibSp = new JTextField();
        this.sibSp.setBounds(survivedLabel.getX() + survivedLabel.getWidth()+SIB_SP_X,survivedLabel.getY()+Y_LOCATION,Constants.COMBO_BOX_WIDTH-WIDTH_OF_LABEL, HEIGHT_OF_LABEL+Constants.COMBO_BOX_HEIGHT);
        add(sibSp);
        this.sibSpLabel = new JLabel("sib sp:");
        this.sibSpLabel.setBounds(survivedLabel.getX(),survivedLabel.getY()+Y_LOCATION,WIDTH,HEIGHT);
        sibSpLabel.setFont(new Font("TimesRoman", Font.PLAIN, FONT_SIZE));
        sibSpLabel.setForeground(Color.white);
        add(sibSpLabel);
        this.parch = new JTextField();
        this.parch.setBounds(survivedLabel.getX()+X_LOCATION,survivedLabel.getY()+ Y_LOCATION,Constants.COMBO_BOX_WIDTH-WIDTH_OF_LABEL, HEIGHT_OF_LABEL+Constants.COMBO_BOX_HEIGHT);
        add(parch);
        this.parchLabel = new JLabel("parch:");
        this.parchLabel.setBounds(survivedLabel.getX()+ X,survivedLabel.getY()+Y,WIDTH,HEIGHT);
        parchLabel.setFont(new Font("TimesRoman", Font.PLAIN, FONT_SIZE));
        parchLabel.setForeground(Color.white);
        add(parchLabel);
        this.ticket = new JTextField();
        this.ticket.setBounds(survivedLabel.getX() + X_LOCATION,survivedLabel.getY()+Y_LOCATION,Constants.COMBO_BOX_WIDTH-WIDTH_OF_LABEL, HEIGHT_OF_LABEL+Constants.COMBO_BOX_HEIGHT);
        add(ticket);
        this.ticketLabel = new JLabel("ticket:");
        this.ticketLabel.setBounds(survivedLabel.getX() + X,survivedLabel.getY()+Y_LOCATION,WIDTH,HEIGHT);
        ticketLabel.setFont(new Font("TimesRoman", Font.PLAIN, FONT_SIZE));
        ticketLabel.setForeground(Color.white);
        add(ticketLabel);
        this.cabin = new JTextField();
        this.cabin.setBounds(survivedLabel.getX() + X_LOCATION,survivedLabel.getY()+ LABELS_Y,Constants.COMBO_BOX_WIDTH-WIDTH_OF_LABEL, HEIGHT_OF_LABEL+Constants.COMBO_BOX_HEIGHT);
        add(cabin);
        this.cabinLabel = new JLabel("cabin:");
        this.cabinLabel.setBounds(survivedLabel.getX() + X,survivedLabel.getY()+LABELS_Y,WIDTH,HEIGHT);
        cabinLabel.setFont(new Font("TimesRoman", Font.PLAIN, FONT_SIZE));
        cabinLabel.setForeground(Color.white);
        add(cabinLabel);
        this.minId = new JTextField();
        this.minId.setBounds(survivedLabel.getX() + survivedLabel.getWidth() , survivedLabel.getY()+ID_Y, Constants.COMBO_BOX_WIDTH-WIDTH_OF_LABEL, HEIGHT_OF_LABEL+Constants.COMBO_BOX_HEIGHT);
        add(minId);
        JLabel maxIdRangeLabel = new JLabel("min: ");
        maxIdRangeLabel.setFont(new Font("TimesRoman", Font.PLAIN, FONT_SIZE));
        maxIdRangeLabel.setBounds(survivedLabel.getX() + survivedLabel.getWidth() , survivedLabel.getY()+Y_OF_LABELS, Constants.COMBO_BOX_WIDTH-WIDTH_OF_LABEL, HEIGHT_OF_LABEL+Constants.COMBO_BOX_HEIGHT);
        maxIdRangeLabel.setFont(new Font("TimesRoman", Font.PLAIN, FONT_SIZE));
        maxIdRangeLabel.setForeground(Color.white);
        this.add(maxIdRangeLabel);
        this.maxId = new JTextField();
        this.maxId.setBounds(survivedLabel.getX() + survivedLabel.getWidth() + X_LABELS, survivedLabel.getY()+ID_Y, Constants.COMBO_BOX_WIDTH-WIDTH_OF_LABEL, HEIGHT_OF_LABEL+Constants.COMBO_BOX_HEIGHT);
        add(maxId);
        this.id = new JLabel("id:");
        this.id.setBounds(survivedLabel.getX(),survivedLabel.getY()+ID_LABEL_Y,WIDTH,HEIGHT);
        id.setFont(new Font("TimesRoman", Font.PLAIN, FONT_SIZE));
        id.setForeground(Color.white);
        add(id);
        this.minFareLabel = new JLabel("min:");
        this.minFareLabel.setBounds(survivedLabel.getX() + survivedLabel.getWidth()+X_MIN_FARE , survivedLabel.getY()+MIN_MAX_FARE_Y, Constants.COMBO_BOX_WIDTH-WIDTH_OF_LABEL, HEIGHT_OF_LABEL+Constants.COMBO_BOX_HEIGHT);
        minFareLabel.setFont(new Font("TimesRoman", Font.PLAIN, FONT_SIZE));
        minFareLabel.setForeground(Color.white);
        add(minFareLabel);
        this.maxFareLabel = new JLabel("max:");
        this.maxFareLabel.setBounds(survivedLabel.getX() + survivedLabel.getWidth() + X_LABELS, survivedLabel.getY()+MIN_MAX_FARE_Y, Constants.COMBO_BOX_WIDTH-WIDTH_OF_LABEL, HEIGHT_OF_LABEL+Constants.COMBO_BOX_HEIGHT);
        maxFareLabel.setFont(new Font("TimesRoman", Font.PLAIN, FONT_SIZE));
        maxFareLabel.setForeground(Color.white);
        add(maxFareLabel);
        this.maxFare = new JTextField();
        this.maxFare.setBounds(survivedLabel.getX() + survivedLabel.getWidth() + X_LABELS, survivedLabel.getY()+FARE_Y, Constants.COMBO_BOX_WIDTH-WIDTH_OF_LABEL, HEIGHT_OF_LABEL+Constants.COMBO_BOX_HEIGHT);
        add(maxFare);
        this.minFare = new JTextField();
        this.minFare.setBounds(survivedLabel.getX() + survivedLabel.getWidth() , survivedLabel.getY()+FARE_Y, Constants.COMBO_BOX_WIDTH-WIDTH_OF_LABEL, HEIGHT_OF_LABEL+Constants.COMBO_BOX_HEIGHT);
        add(minFare);
        this.fare = new JLabel( "fare:");
        this.fare.setBounds(survivedLabel.getX()  , survivedLabel.getY()+FARE_Y, Constants.COMBO_BOX_WIDTH-WIDTH_OF_LABEL, HEIGHT_OF_LABEL+Constants.COMBO_BOX_HEIGHT);
        fare.setFont(new Font("TimesRoman", Font.PLAIN, FONT_SIZE));
        fare.setForeground(Color.white);
        add(fare);
        this.submit = new JButton("submit");
        this.submit.setBounds(survivedLabel.getX() + survivedLabel.getWidth(),BUTTON_SIZE1,BUTTON_SIZE2,HEIGHT);
        submit.setFont(new Font("TimesRoman", Font.PLAIN, FONT_SIZE));
        add(submit);
        this.embarkedSurvived = new JComboBox<>(Constants.PASSENGER_EMBARKED_OPTIONS);
        this.embarkedSurvived.setBounds(survivedLabel.getX()+survivedLabel.getWidth(),survivedLabel.getY()+EMBARKED_Y,Constants.COMBO_BOX_WIDTH,Constants.COMBO_BOX_HEIGHT);
        this.add(embarkedSurvived);
        this.embarked = new JLabel("embarked");
        this.embarked.setBounds(survivedLabel.getX(),survivedLabel.getY()+EMBARKED_Y,Constants.COMBO_BOX_WIDTH+HEIGHT_OF_LABEL,Constants.COMBO_BOX_HEIGHT);
        embarked.setFont(new Font("TimesRoman", Font.PLAIN, FONT_SIZE));
        embarked.setForeground(Color.white);
        add(embarked);
        this.survivedComboBox = new JComboBox<>(Constants.PASSENGER_CLASS_OPTIONS);
        this.survivedComboBox.setBounds(survivedLabel.getX() + survivedLabel.getWidth() , survivedLabel.getY(), Constants.COMBO_BOX_WIDTH, Constants.COMBO_BOX_HEIGHT);
        this.add(this.survivedComboBox);
        this.sex = new JLabel("sex");
        this.sex.setBounds(survivedLabel.getX(),survivedLabel.getY()+LABELS_Y,Constants.COMBO_BOX_WIDTH,Constants.COMBO_BOX_HEIGHT);
        sex.setFont(new Font("TimesRoman", Font.PLAIN, FONT_SIZE));
        sex.setForeground(Color.white);
        add(sex);
        this.sexSurvived = new JComboBox<>(Constants.PASSENGER_SEX_OPTIONS);
        this.sexSurvived.setBounds(survivedLabel.getX()+survivedLabel.getWidth(),survivedLabel.getY()+LABELS_Y,Constants.COMBO_BOX_WIDTH,Constants.COMBO_BOX_HEIGHT);
        add(sexSurvived);
        this.summary = new JLabel(" ");
        this.summary.setBounds(SUMMARY_X,SUMMARY_Y,SUMMARY_WIDTH,HEIGHT);
        this.summary.setFont(new Font("TimesRoman", Font.BOLD, FONT_SIZE));
        add(summary);
        this.statistic = new JButton("create statistic file");
        this.statistic.setBounds(STATISTIC_X,STATISTIC_Y,STATISTIC_WIDTH,HEIGHT);
        add(statistic);


        this.submit.addActionListener( (e) -> {
            List <Passengers> newList = passengersList;
            String chooseOfUser = (String) survivedComboBox.getSelectedItem();
            newList = mainSortByClass(chooseOfUser,passengersList);
            newList= mainSortBySex(String.valueOf(sexSurvived.getSelectedItem()),newList);
            newList=mainSortById(newList, minId.getText(), maxId.getText());
            newList = sortByName(newList,subStringName.getText());
            try {
                newList = sortBySibSp(newList, Integer.parseInt(sibSp.getText()));
            } catch (Exception exception){
                newList = withOutSort(newList,NO_SORT);
            }
            try {
                newList = sortByParch(newList, Integer.parseInt(parch.getText()));
            } catch (Exception exception){
                newList = withOutSort(newList,NO_SORT);
            }
            try {
                newList = sortByTicket(newList, Integer.parseInt(ticket.getText()));
            } catch (Exception exception){
                newList = withOutSort(newList,NO_SORT);
            }
            try {
                newList = sortByCabin(newList, cabin.getText());
            } catch (Exception exception){
                newList = withOutSort(newList,NO_SORT);
            }
          newList = mainSortByEmbarked(newList,(String) embarkedSurvived.getSelectedItem());
          newList = mainSortByFare(newList,minFare.getText(),maxFare.getText());
          System.out.println(newList);

          summary.setText("Total Rows: "+ newList.size() +  "("+howManySurvived(newList)+ " survived" +", " +howManyNotSurvived(newList)  + " did not)");
          summary.setForeground(Color.white);
            try {
                writeToFile(newList,number);
                number++;
            } catch (IOException ex) {
                ex.printStackTrace();
            }

        });
        this.statistic.addActionListener( (e -> {
           String summaryOfStatistics =("statistics by class:" +
                    "\n" + " first class:" + statisticOfClass("1st", passengersList)) + "%" +
                    "\n"+ "second class:" + statisticOfClass("2nd",passengersList) + "%" + "\n" +
            "third class:" +statisticOfClass("3rd",passengersList)+ "%"+"\n"+"\n"+
                "statistics by sex:"+"\n"+"by male:"+ statisticOfSex("male",passengersList)+"%"+"\n"+
                   "by female:"+ statisticOfSex("female",passengersList)+"\n"+"\n"+
                   "statistics by age:"+"\n"+"0-10:"+ statisticByAge(MIN_AGE1,MAX_AGE1,passengersList)+"%"+"\n"+
                   "11-20:"+ statisticByAge(MIN_AGE2,MAX_AGE2,passengersList)+"%"+"\n"+
                   "21-30:"+ statisticByAge(MIN_AGE3,MAX_AGE3,passengersList)+"%"+"\n"+
                   "31-40:"+ statisticByAge(MIN_AGE4,MAX_AGE4,passengersList)+"%"+"\n"+
                   "41-50:"+ statisticByAge(MIN_AGE5,MAX_AGE5,passengersList)+"%"+"\n"+
                   "51+:"+ statisticByAge(MIN_AGE6,MAX_AGE6,passengersList)+"%"+"\n"+"\n"+
                   "statistics by family:"+"\n"+"have family:"+ statisticsByFamily(0,passengersList)+"\n"+
                   "doesnt have family:"+ statisticsByFamily(1,passengersList)+"\n"+"\n"+
                   "statistics by fare:"+"\n"+"0-10:"+ statisticByFare("0","10",passengersList)+"\n"+
                   "11-30:" + statisticByFare("11","30",passengersList)+"\n"+
                   "31+:"+ statisticByFare("31","0",passengersList)+"\n"+"\n"+
                   "statistics by embarked:"+"\n"+"embarked S:"+ statisticByEmbarked("S",passengersList)+"\n"+
                   "embarked Q:"+ statisticByEmbarked("Q",passengersList)+"\n"+
                   "embarked C:"+ statisticByEmbarked("C",passengersList);
            System.out.println(summaryOfStatistics);
            try {
                writeToStatisticFile(summaryOfStatistics);
            } catch (IOException ex) {
                ex.printStackTrace();
            }


        }) );

    }
    public static void writeToStatisticFile ( String text) throws IOException {
        FileWriter fileWriter = new FileWriter(Constants.PATH_T0_STATISTIC_FILE);
        fileWriter.write(text);
        fileWriter.close();
    }

    public static float statisticByEmbarked (String embarked , List<Passengers>passengers){
        List<Passengers> typeOfEmbarked = sortByEmbarked(passengers,embarked);
        int size = typeOfEmbarked.size();
        int survived = howManySurvived(typeOfEmbarked);
        float result = (float) percent(survived,size);
        return result;
    }

    public static float statisticByFare (String min, String max , List<Passengers>passengers){
        List<Passengers> fare = sortByFare(passengers,min,max);
        int size = fare.size();
        int survived = howManySurvived(fare);
        float result = (float) percent(survived,size);
        return result;


    }

    public static float statisticsByFamily (int number, List<Passengers>passengers){
        List<Passengers> family = sortByFamily(passengers,number);
        int size = family.size();
        int survived = howManySurvived(family);
      float result = (float) percent(survived,size);
      return result;

    }

    public static List<Passengers> sortByFamily (List<Passengers> passengers,int number){
        return passengers.stream().filter(passenger -> passenger.family(number)).collect(Collectors.toList());
    }

   public static float statisticByAge (int min, int max,List<Passengers>passengers) {
        List<Passengers> rangeAge =sortByAge(passengers,min,max);
        int size = rangeAge.size();
        int survived= howManySurvived(rangeAge);
        float result= (float) percent(survived,size);
        return result;
   }

    public static List<Passengers> sortByAge (List<Passengers> passengers,int minNumber,int maxNumber){
        return passengers.stream().filter(passenger -> passenger.age(minNumber,maxNumber)).collect(Collectors.toList());
    }

    public static float statisticOfSex (String sex, List<Passengers>passengers){
        List<Passengers> bySex = mainSortBySex(sex,passengers);
        int survived = howManySurvived(bySex);
        int size = bySex.size();
        float result = (float) percent(survived,size);
        return result;
    }

    public static float statisticOfClass (String nameOfClass,List<Passengers>passengers){
        List<Passengers>class1 = mainSortByClass(nameOfClass,passengers);
        int survived=howManySurvived(class1);
        int size = class1.size();
        float result = (float) percent(survived,size);
        return result;
    }

    public static double percent (int number, double sum) {
        double result = (number / sum ) * 100;
        return result;
    }

    public static List<Passengers> mainSortById (List<Passengers> passengers,String min, String max){
        if (Objects.equals(min, "") && Objects.equals(max, "")){
            return passengers;
        }
      return sortById(passengers,min,max);
    }

    public static List<Passengers> mainSortByFare (List<Passengers> passengers,String min, String max){
        if (Objects.equals(min, "") && Objects.equals(max, "")){
            return passengers;
        }
        return sortByFare(passengers,min,max);
    }

    public static List<Passengers> sortByFare (List<Passengers> passengers,String minNumber,String maxNumber){
        return passengers.stream().filter(passenger -> passenger.rangeOfFare(minNumber,maxNumber)).collect(Collectors.toList());
    }
    public static void writeToFile ( List<Passengers> passengers, int number) throws IOException {
        FileWriter fileWriter = new FileWriter("C:\\Users\\USER\\Desktop\\לימודים\\סמסטר ב\\שי סדנא לתכנות\\טיטאניק\\" + "csv."+number+".csv");
        fileWriter.write(String.valueOf(passengers));
        fileWriter.close();
    }

    public static int howManySurvived (List<Passengers>passengers){
        return (int) passengers.stream().filter(Passengers::Survived).count();
    }
    public static int howManyNotSurvived (List<Passengers>passengers){
        return (int) passengers.stream().filter(Passengers::notSurvived).count();
    }
    public static List<Passengers> withOutSort(List <Passengers> passengers, int number){
        if (number == -1){
            return passengers;
        }
       return sortBySibSp(passengers,number);
    }



    public  static List<Passengers> mainSortByEmbarked (List<Passengers>passengers, String embarked){
        if (Objects.equals(embarked, "All")){
            return passengers;
        }
          List<Passengers> passengersList = sortByEmbarked(passengers,embarked);
        return passengersList;
    }

    public static List<Passengers> sortByEmbarked (List<Passengers> passengers, String embarked){
        return passengers.stream().filter(passenger -> passenger.embarked(embarked)).collect(Collectors.toList());

    }

    public static List<Passengers> sortByCabin (List<Passengers> passengers, String number){
        return passengers.stream().filter(passenger -> passenger.cabin(number)).collect(Collectors.toList());

    }
    public static List<Passengers> sortByTicket (List<Passengers> passengers, int number){
        return passengers.stream().filter(passenger -> passenger.ticket(number)).collect(Collectors.toList());

    }

    public static List<Passengers> sortByParch (List<Passengers> passengers, int amount){
        return passengers.stream().filter(passenger -> passenger.parch(amount)).collect(Collectors.toList());

    }
    public static List<Passengers> sortBySibSp(List<Passengers> passengers, int amount){
        return passengers.stream().filter(passenger -> passenger.sibSp(amount)).collect(Collectors.toList());

    }

    public static List<Passengers> sortById (List<Passengers> passengers,String minNumber,String maxNumber){
        return passengers.stream().filter(passenger -> passenger.rangeOfId(minNumber,maxNumber)).collect(Collectors.toList());
    }

    public static List<Passengers> sortByName (List<Passengers> passengers,String nameOfUser){
        return passengers.stream().filter(passenger -> passenger.stringContained(nameOfUser)).collect(Collectors.toList());
    }



    public static List<Passengers> mainSortByClass (String chooseOfUser,List<Passengers> passengersList){
        List<Passengers> passengers = passengersList;
        if (chooseOfUser.equals("1st")){
           passengers = sortByClass(passengersList,TYPE_OF_CLASS1);
        }
        if (chooseOfUser.equals("2nd")){
            passengers= sortByClass(passengersList,TYPE_OF_CLASS2);
        }
        if (chooseOfUser.equals("3rd")){
            passengers =sortByClass(passengersList,TYPE_OF_CLASS3);
        }
        return passengers;
    }

    public static List<Passengers> sortByClass(List <Passengers> passengers, int typeOfClass){
        return passengers.stream().filter(passenger -> passenger.typeOfClass(typeOfClass)).collect(Collectors.toList());
    }

    public static List<Passengers> mainSortBySex (String sex, List<Passengers> passengers){
        List <Passengers> passengersList = passengers;
        if (sex.equals("male")){
            passengersList =sortBySex(passengers, "male");
        }
        if (sex.equals("female")){
            passengersList =sortBySex(passengers, "female");
        }
        return passengersList;
    }

    public static List<Passengers> sortBySex(List <Passengers> passengers, String sex){
        return passengers.stream().filter(passenger -> passenger.typeOfSex(sex)).collect(Collectors.toList());
    }
    protected void paintComponent (Graphics g){
        super.paintComponent(g);
        if (this.titanic != null) {
            g.drawImage(this.titanic.getImage(), BACKGROUND_X_Y, BACKGROUND_X_Y, BACKGROUND_WIDTH, BACKGROUND_HEIGHT, null);
        }
    }



}
