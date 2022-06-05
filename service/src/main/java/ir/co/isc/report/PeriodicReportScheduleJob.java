package ir.co.isc.report;


import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class PeriodicReportScheduleJob {


    @Scheduled(fixedDelay = 600000) //run per 10 minute
    public void run() {

        double freeMemByte = Runtime.getRuntime().freeMemory();
        double totalMemByte = Runtime.getRuntime().totalMemory();
        double sizeFreeKB = freeMemByte / 1024;
        double sizeTotalKB = totalMemByte / 1024;
        double sizeFreeMG = sizeFreeKB / 1024;
        double sizeTotalMG = sizeTotalKB / 1024;
        double useMemMG = sizeTotalMG - sizeFreeMG;
        System.out.println(" \t total memory (MB) = " + sizeTotalMG +
                " \t \t free memory (MG) = " + sizeFreeMG +
                " \t \t use memory (MG) = " + useMemMG);
    }
}
