import net.sf.jasperreports.engine.DefaultJasperReportsContext;
import net.sf.jasperreports.engine.JRPropertiesUtil;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JRCompiler;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;

public class MyCompiler {
    public static void main(String[] args) {
        try {
            JasperDesign jasperDesign = JRXmlLoader.load("/Users/agus/jasper/login_history_new.jrxml");

            JRPropertiesUtil.getInstance(DefaultJasperReportsContext.getInstance())
                    .setProperty("net.sf.jasperreports.compiler.class", "net.sf.jasperreports.compilers.JRGroovyCompiler");


            JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);

            net.sf.jasperreports.engine.util.JRSaver.saveObject(jasperReport, "/Users/agus/jasper/login_history_new.jasper");


            // Set the default compiler to Groovy
//            JRPropertiesUtil.getInstance(DefaultJasperReportsContext.getInstance())
//                    .setProperty("net.sf.jasperreports.compiler.class", "net.sf.jasperreports.compilers.JRGroovyCompiler");
//
//            // Compile the report
//            JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
//
//            // Optionally, you can serialize the compiled report to a .jasper file
//            net.sf.jasperreports.engine.util.JRSaver.saveObject(jasperReport, "/Users/agus/jasper/login_history_new.jasper");
//
//            System.out.println("Report compiled successfully with Groovy.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
