package com.example.Assignment_A1;

import com.example.Assignment_A1.model.Ticket;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.Writer;
import java.util.List;

@Component
public class CSVFileGenerator {
    public void writeTicketsToCSV(List<Ticket>tickets, int idConcert, Writer writer ){
        try{
            CSVPrinter printer = new CSVPrinter(writer, CSVFormat.DEFAULT );
            int ok=0;
            for (Ticket t: tickets){
                if(t.getConcertId() == idConcert){
                    ok=1;
                    printer.printRecord(t.getIdTicket(),t.getConcertId(),t.getName(),t.getPlaces(),t.getPrice());
                }
            }
            if(ok==0){
                printer.printRecord("No tickets were sold for this concert");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
