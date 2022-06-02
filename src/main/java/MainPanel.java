import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MainPanel extends JPanel {
    private JComboBox<String> survivedComboBox;
    private JComboBox<String> sexSurvived;
    private JComboBox<String> embarkedSurvived;


    private List <Passengers> passengersList;
    private JTextField minRange;
    private JTextField maxRange;
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


    private JButton submit;


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

        } catch (FileNotFoundException e){
            e.printStackTrace();

        }
        this.setLayout(null);
        this.setBounds(x, y + Constants.MARGIN_FROM_TOP, width, height);
        JLabel survivedLabel = new JLabel("Passenger Class: ");
        survivedLabel.setBounds(x + Constants.MARGIN_FROM_LEFT, y, Constants.LABEL_WIDTH, Constants.LABEL_HEIGHT);
        this.add(survivedLabel);
        JLabel minRangeLabel = new JLabel("min: ");
        minRangeLabel.setFont(new Font("TimesRoman", Font.PLAIN, 20));
        minRangeLabel.setBounds(survivedLabel.getX() + survivedLabel.getWidth()+70 , survivedLabel.getY()+40, Constants.COMBO_BOX_WIDTH-30, 20+Constants.COMBO_BOX_HEIGHT);
        this.add(minRangeLabel);
        this.subStringName = new JTextField();
        this.subStringName.setBounds(survivedLabel.getX() + survivedLabel.getWidth()+30,survivedLabel.getY()+140,Constants.COMBO_BOX_WIDTH-30, 20+Constants.COMBO_BOX_HEIGHT);
        add(subStringName);
        this.subStringOfName = new JLabel("name");
        this.subStringOfName.setBounds(survivedLabel.getX(),survivedLabel.getY()+140,120,40);
        add(subStringOfName);
        this.sibSp = new JTextField();
        this.sibSp.setBounds(survivedLabel.getX() + survivedLabel.getWidth()+30,survivedLabel.getY()+200,Constants.COMBO_BOX_WIDTH-30, 20+Constants.COMBO_BOX_HEIGHT);
        add(sibSp);
        this.sibSpLabel = new JLabel("sib sp");
        this.sibSpLabel.setBounds(survivedLabel.getX(),survivedLabel.getY()+200,120,40);
        add(sibSpLabel);
        this.parch = new JTextField();
        this.parch.setBounds(survivedLabel.getX()+300,survivedLabel.getY()+140,Constants.COMBO_BOX_WIDTH-30, 20+Constants.COMBO_BOX_HEIGHT);
        add(parch);
        this.parchLabel = new JLabel("parch");
        this.parchLabel.setBounds(survivedLabel.getX()+ 190,survivedLabel.getY()+140,120,40);
        add(parchLabel);
        this.ticket = new JTextField();
        this.ticket.setBounds(survivedLabel.getX() + 300,survivedLabel.getY()+200,Constants.COMBO_BOX_WIDTH-30, 20+Constants.COMBO_BOX_HEIGHT);
        add(ticket);
        this.ticketLabel = new JLabel("ticket");
        this.ticketLabel.setBounds(survivedLabel.getX() + 190,survivedLabel.getY()+200,120,40);
        add(ticketLabel);
        this.cabin = new JTextField();
        this.cabin.setBounds(survivedLabel.getX() + 300,survivedLabel.getY()+260,Constants.COMBO_BOX_WIDTH-30, 20+Constants.COMBO_BOX_HEIGHT);
        add(cabin);
        this.cabinLabel = new JLabel("cabin");
        this.cabinLabel.setBounds(survivedLabel.getX() + 190,survivedLabel.getY()+260,120,40);
        add(cabinLabel);
        this.maxRange = new JTextField();
        this.maxRange.setBounds(survivedLabel.getX() + survivedLabel.getWidth() , survivedLabel.getY()+80, Constants.COMBO_BOX_WIDTH-30, 20+Constants.COMBO_BOX_HEIGHT);
        add(maxRange);
        JLabel maxiRangeLabel = new JLabel("max: ");
        maxiRangeLabel.setFont(new Font("TimesRoman", Font.PLAIN, 20));
        maxiRangeLabel.setBounds(survivedLabel.getX() + survivedLabel.getWidth() , survivedLabel.getY()+40, Constants.COMBO_BOX_WIDTH-30, 20+Constants.COMBO_BOX_HEIGHT);
        this.add(maxiRangeLabel);
        this.minRange = new JTextField();
        this.minRange.setBounds(survivedLabel.getX() + survivedLabel.getWidth() + 59, survivedLabel.getY()+80, Constants.COMBO_BOX_WIDTH-30, 20+Constants.COMBO_BOX_HEIGHT);
        add(minRange);
        this.submit = new JButton("submit");
        this.submit.setBounds(150,400,100,40);
        add(submit);
        this.embarkedSurvived = new JComboBox<>(Constants.PASSENGER_EMBARKED_OPTIONS);
        this.embarkedSurvived.setBounds(survivedLabel.getX()+survivedLabel.getWidth(),survivedLabel.getY()+300,Constants.COMBO_BOX_WIDTH,Constants.COMBO_BOX_HEIGHT);
        this.add(embarkedSurvived);
        this.embarked = new JLabel("embarked");
        this.embarked.setBounds(survivedLabel.getX()+survivedLabel.getWidth()-80,survivedLabel.getY()+300,Constants.COMBO_BOX_WIDTH,Constants.COMBO_BOX_HEIGHT);
        add(embarked);
        this.survivedComboBox = new JComboBox<>(Constants.PASSENGER_CLASS_OPTIONS);
        this.survivedComboBox.setBounds(survivedLabel.getX() + survivedLabel.getWidth() + 1, survivedLabel.getY(), Constants.COMBO_BOX_WIDTH, Constants.COMBO_BOX_HEIGHT);
        this.add(this.survivedComboBox);
        this.sex = new JLabel("sex");
        this.sex.setBounds(survivedLabel.getX()+survivedLabel.getWidth()-30,survivedLabel.getY()+260,Constants.COMBO_BOX_WIDTH,Constants.COMBO_BOX_HEIGHT);
        add(sex);
        this.sexSurvived = new JComboBox<>(Constants.PASSENGER_SEX_OPTIONS);
        this.sexSurvived.setBounds(survivedLabel.getX()+survivedLabel.getWidth(),survivedLabel.getY()+260,Constants.COMBO_BOX_WIDTH,Constants.COMBO_BOX_HEIGHT);
        add(sexSurvived);


        this.submit.addActionListener( (e) -> {

           // this.survivedComboBox.addActionListener((e1) -> {
            String chooseOfUser = (String) survivedComboBox.getSelectedItem();
//          passengersList = mainSortByClass(chooseOfUser,passengersList);
//          passengersList=mainSortById(minRange.getText(),maxRange.getText(),passengersList);
//          String sexOfChoose = (String)(sexSurvived.getSelectedItem());
//          passengersList= mainSortBySex(String.valueOf(sexSurvived.getSelectedItem()),passengersList);
//          passengersList=mainSortById(minRange.getText(),maxRange.getText(),passengersList);
//          passengersList = sortByName(passengersList,subStringName.getText());
            passengersList = mainSortBySibSp(passengersList, Integer.parseInt(sibSp.getText()));
//          passengersList = sortByParch(passengersList, Integer.parseInt(parch.getText()));
//          passengersList = sortByTicket(passengersList, Integer.parseInt(ticket.getText()));
//          passengersList = sortByCabin(passengersList, cabin.getText());
//          passengersList = mainSortByEmbarked(passengersList,(String) embarkedSurvived.getSelectedItem());
            System.out.println(passengersList);




        });


    }
    public static List<Passengers> mainSortBySibSp (List <Passengers> passengers,int number){
        if (number == -1){
            return passengers;
        }
       return sortBySibSp(passengers,number);
    }



    public static List<Passengers> mainSortById (String min, String max,List<Passengers>passengers){
        List<Passengers> passengersList = passengers;
        if (min != null && max.isEmpty()){
            passengersList =sortById(passengers,min, max);
        }
        if (min.isEmpty() && max !=null){
             passengersList=sortById(passengers, min,max);
        }
        if (min != null && max !=null){
          passengersList =sortById(passengers,min,max);
        }
        return passengersList;
    }

    public  static List<Passengers> mainSortByEmbarked (List<Passengers>passengers, String embarked){
        if (embarked == "All"){
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
        if (chooseOfUser.equals("All")) {
            for (int i = 0; i < passengersList.size(); i++) {
               // System.out.println(passengersList.get(i).toString());
            }
        }
        if (chooseOfUser.equals("1st")){
           passengers = sortByClass(passengersList,1);
        }
        if (chooseOfUser.equals("2nd")){
            passengers= sortByClass(passengersList,2);
        }
        if (chooseOfUser.equals("3rd")){
            passengers =sortByClass(passengersList,3);
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



}
