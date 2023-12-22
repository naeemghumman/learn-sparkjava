package spark.learning.config;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.Version;
import spark.ModelAndView;
import spark.TemplateEngine;

import java.io.IOException;
import java.io.StringWriter;
import java.util.Map;

public class FreeMarkerTemplateEngine extends TemplateEngine {

    private final Configuration configuration;

    public FreeMarkerTemplateEngine() {
        // The version number corresponds to the specific version of the FreeMarker dependency
        this.configuration = new Configuration(new Version(2,3,32));
        this.configuration.setClassForTemplateLoading(FreeMarkerTemplateEngine.class, "/templates/freemarker");
    }

    @Override
    public String render(ModelAndView modelAndView) {
        try {
            Map<String, Object> model = (Map<String, Object>) modelAndView.getModel();
            Template template = configuration.getTemplate(modelAndView.getViewName());
            return processTemplateIntoString(template, model);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static String processTemplateIntoString(Template template, Map<String, Object> model) {
        try {
            StringWriter stringWriter = new StringWriter();
            template.process(model, stringWriter);
            return stringWriter.toString();
        } catch (TemplateException | IOException e) {
            // Handle exception appropriately (e.g., log error, throw custom exception)
            e.printStackTrace();
            return null;
        }
    }
}
