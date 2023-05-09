import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Project extends Application {

    private TextField yearT = new TextField();
    private TextField monthT = new TextField();
    private Button btShow = new Button("Show");
    private Label show = new Label();
    int month, year;

    @Override
    public void start(Stage primaryStage) {
        GridPane pane = new GridPane();
        pane.setAlignment(Pos.CENTER);
        pane.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
        pane.setHgap(5.5);
        pane.setVgap(5.5);

        pane.add(new Label("Enter the year:"), 0, 0);
        pane.add(yearT, 1, 0);
        pane.add(new Label("Enter the Month:"), 0, 1);
        pane.add(monthT, 1, 1);
        pane.add(btShow, 1, 3);
        GridPane.setHalignment(btShow, HPos.CENTER);
        pane.add(show, 1, 4);
        btShow.setOnAction((ActionEvent a) -> {
            try {
                month = Integer.parseInt(monthT.getText());
                year = Integer.parseInt(yearT.getText());
                if (month > 0 && month < 13) {
                    show.setText(printMonth(year, month));
                } else {
                    show.setText("\n\n\n\nPlease Enter valid Average of months");
                }
            } catch (Exception ex) {
                show.setText("\n\n\n\nPlease Enter valid values");
            }
        });

        Scene scene = new Scene(pane, 500, 500);
        primaryStage.setTitle("Calendar");
        primaryStage.setScene(scene);
        primaryStage.show();
        primaryStage.setWidth(500);
        primaryStage.setHeight(500);
    }

    public static void main(String[] args) {
        launch(args);
    }

    public static String printMonth(int year, int month) {
        String str = "";
        str += printMonthTitle(year, month);
        str += printMonthBody(year, month);
        return str;
    }

    public static String printMonthTitle(int year, int month) {
        String str = "";
        String nameOfThisMonth = getMonthName(month);
        str += "                        " + nameOfThisMonth + " / " + ("" + year) + "\n";
        str += "_______________________________________________\n";
        return str;
    }

    public static String printMonthBody(int year, int month) {
        String str = "";
        str += "Sat     Sun    Mon     Tue     Wed     Thu     Fri\n";
        int startDay = getStartDay(year, month);
        int numberOfDaysInMonth = getNumberOfDaysInMonth(year, month);
        int y;
        for (y = 0; y < startDay; y++) {
            str += "           ";
        }
        for (y = 1; y <= numberOfDaysInMonth; y++) {
            if (y < 10) {
                str += "  " + y + "       ";
            } else {
                str += " " + y + "      ";
            }
            if ((y + startDay) % 7 == 0) {
                str += "\n";
            }
        }
        return str;
    }

    public static int getStartDay(int year, int month) {
        int startDay = (getTotalNumberOfDays(year, month) + 4) % 7;
        return startDay;
    }

    public static int getTotalNumberOfDays(int year, int month) {
        int totalNumberOfDays = 0;
        for (int i = 1800; i < year; i++) {
            if (isALeapYear(i)) {
                totalNumberOfDays += 366;
            } else {
                totalNumberOfDays += 365;
            }
        }
        for (int j = 1; j < month; j++) {
            totalNumberOfDays += getNumberOfDaysInMonth(year, j);
        }
        return totalNumberOfDays;
    }

    public static int getNumberOfDaysInMonth(int year, int month) {
        if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
            return 31;
        } else if (month == 4 || month == 6 || month == 9 || month == 11) {
            return 30;
        } else {
            if (isALeapYear(year)) {
                return 29;
            }
            return 28;
        }
    }

    public static boolean isALeapYear(int year) {
        if (((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0)) {
            return true;
        }
        return false;
    }

    public static String getMonthName(int month) {
        String monthName = "";
        switch (month) {
            case 1:
                monthName = "January";
                break;
            case 2:
                monthName = "February";
                break;
            case 3:
                monthName = "March";
                break;
            case 4:
                monthName = "April";
                break;
            case 5:
                monthName = "May";
                break;
            case 6:
                monthName = "June";
                break;
            case 7:
                monthName = "July";
                break;
            case 8:
                monthName = "Augest";
                break;
            case 9:
                monthName = "Septemper";
                break;
            case 10:
                monthName = "October";
                break;
            case 11:
                monthName = "November";
                break;
            case 12:
                monthName = "December";
                break;
        }
        return monthName;
    }
}