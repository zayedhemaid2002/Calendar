# Calendar


#  Print Month Method:
In this method it will take a year and a month and initialize variable which Is called
here str then it will call printMonthTitle and printMonthBody methods to present
the calendar on a screen GUI

            procedure printMonth (year, month: integers)
            str := "" {Empty String}
            str := str + printMonthTitle(year, month)
            str := str + printMonthBody(year, month)
            return str

#  Print Month Title Method:
In this method it will take a year and a month and then we will initialize variable
which is here called str then we will call getMonthName method to print the Title(month/year).

            procedure printMonthTitle (year, month: integers)
            str := "" {Empty String}
            nameOfThisMonth := getMonthName(month)
            str := str + "" +nameOfThisMonth + " / "+ ("" + year)
            str := str + " _______________________________________________"
            return str

#  Print Month Body Method:
In this method it will take a year and a month and it will print the month body by
calling getStartDay method then it passes to for loop and print the days.

            procedure printMonthBody (year, month: integers)
            str := "" {Empty String}
            str := str + "Sat Sun Mon Tue Wed Thu Fri"
            startDay := getStartDay(year, month)
            numberOfDaysInMonth := getNumberOfDaysInMonth(year, month)
            for y := 0 to startDay
            begin
            str := str+ " ";
            end
            for y := 0 to numberOfDaysInMonth
            begin
            if (y < 10) then str := str+ " " + y + " "
            else str := str+ " " + y + " "
            if ((y + startDay) mod 7 = 0) then str := str+"\n"
            end
            return str

#  Get Start Day Method:
In this method it will take a year and a month to return the first day at the year by
using the method getTotalNumberOfDays +4 and mod 7.

            procedure getStartDay (year, month: integers)
            startDay := (getTotalNumberOfDays(year, month) + 4) mod 7
            return startDay

#  Get Total Number Of Days Method:
In this method it will take a year and a month then will initialize a variable which
is here called totalNumberOfDays then will start a for loop from 1800 to the year
it will be entered and will be checked if it a leap year then it will return
totalNumberOfDays + 366 and if it’s not it will return totalNumberOfDays + 365
Then it will start a new for loop from 1 to month which will be entered then it will
call getNumberOfDaysInMonth method and add totalNumberOfDays and at the
end it will return totalNumberOfDays.

            procedure getTotalNumberOfDays (year, month: integers)
            totalNumberOfDays:= 0
            for i := 1800 to year
            begin
            if isALeapYear(i) then totalNumberOfDays:= totalNumberOfDays + 366
            else totalNumberOfDays:= totalNumberOfDays + 365
            end
            for i := 1 to month
            begin
            totalNumberOfDays:= totalNumberOfDays + getNumberOfDaysInMonth (year, j)
            end
            return totalNumOfDays

#  Get Number Of Days Month Method:
In this method it will take two values a year and month then it will check it by
multi- if statements and then it will return 31 if the month is 1 or 3 or 5 or 7 or 8
or 10 or 12 or it will return 30 if the month is 4 or 6 or 9 or 11 else, if the year is a
leap year it will return 29 else it will return 28.

            procedure getNumOfDaysInMonth (year, month: integers)
            if (month = 1 ∨ month = 3 ∨ month = 5 ∨ month = 7 ∨ month = 8 ∨ month = 10 ∨ month
            = 12) then
            return 31
            else if (month = 4 ∨ month = 6 ∨ month = 9 ∨ month = 11) then
            return 30
            else
            if (isALeapYear (year)) then
            return 29
            else
            return 28

#  Is Aleap Year Method:
In this method it will take a year then it will check it if the year mod 4 = 0 and the
year mod 100 ≠ 0, or the year mod 400 = 0. It will be a leap year else it will be a
normal year.

            procedure isALeapYear (year: integer)
            if (((year mod 4 = 0) ∧ (year mod 100 ≠ 0)) ∨ (year mod 400 = 0)) then
            return true
            else
            return false

#  Get Month Name Method:
In this method it will take a month, then it will check it by multi- if statements and
then return month name. if month value will be 1 it will return January else if the
month value is 2 it will return February else if the month value is 3 it will return
March else if the month value is 4 it will return April else if the month value is 5
it will return May else if the month value is 6 it will return June else if the month
value is 7 it will return July else if the month value is 8 it will return August else if
the month value is 9 it will return September else if the month value is 10 it will
return October else if the month value is 11 it will return November else if the
month value is 12 it will return December.

            procedure getMonthName (month: integer)
            monthName := “” {Empty String}
            if month = 1 then monthName := January
            else if month = 2 then monthName := February
            else if month = 3 then monthName := March
            else if month = 4 then monthName := April
            else if month = 5 then monthName := May
            else if month = 6 then monthName := June
            else if month = 7 then monthName := July
            else if month = 8 then monthName := August
            else if month = 9 then monthName := September
            else if month = 10 then monthName := October
            else if month = 11 then monthName := November
            else if month = 12 then monthName := December
            return monthName
