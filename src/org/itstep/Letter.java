package org.itstep;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedList;

public class Letter implements Comparable<Letter> {
    private String name;                // наименование документа
    private Date date;                  // дата подготовки документа
    private String sDate;               // строковое значение даты
    private String preparedByWhom;      // кем подготовлено
    private String department;          // отдел - отправитель документа
    private String toWhomItIsIntended;  // кому предназначено
    private String summary;             // краткое содержание
    LinkedList<Letter> letters = new LinkedList<>();

    public Letter(String name, String sDate, String preparedByWhom, String department, String toWhomItIsIntended,
                  String summary) throws ParseException {
        this.name = name;
        this.sDate = sDate;
        this.preparedByWhom = preparedByWhom;
        this.department = department;
        this.toWhomItIsIntended = toWhomItIsIntended;
        this.summary = summary;
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        this.date = dateFormat.parse(sDate);

    }

    public String getName() {
        return name;
    }

    public String getsDate() {
        return sDate;
    }

    public String getPreparedByWhom() {
        return preparedByWhom;
    }

    public String getDepartment() {
        return department;
    }

    public String getToWhomItIsIntended() {
        return toWhomItIsIntended;
    }

    public String getSummary() {
        return summary;
    }

    public Date getDate() {
        return date;
    }

    private void sort() {
        Collections.sort(letters);
    }


    public String toStringLetter() {
        final StringBuffer buffer = new StringBuffer("");
        buffer.append(name);
        buffer.append(" от ").append(sDate);
        buffer.append(" (отдел ").append(department);
        buffer.append(") направлено: ").append(toWhomItIsIntended);
        buffer.append(" от ").append(preparedByWhom);
        buffer.append(" Содержание: ").append(summary);
        buffer.append("\n");
        return buffer.toString();
    }

    @Override
    public int compareTo(Letter letter) {
        Date date1 = getDate();
        Date date2 = letter.getDate();
        return date1.compareTo(date2);
    }
}