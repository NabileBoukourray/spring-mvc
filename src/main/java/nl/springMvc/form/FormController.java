package nl.springMvc.form;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

@Controller
public class FormController {

    private Logger logger = Logger.getLogger(getClass().getName());

    @InitBinder
    private void initBinder(WebDataBinder binder) {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        binder.registerCustomEditor(String.class, stringTrimmerEditor);
    }

    @GetMapping("/form")
    public String form(@RequestParam(name="naam", required = false) String naam,
                       @RequestParam(name="bedrijf", required = false) String bedrijf,
                       @RequestParam(name="startdatum", required = false) String startdatum,
                       @RequestParam(name="einddatum", required = false) String einddatum,
                       @RequestParam(name="options", required = false) List<String> options,
                       Model model){


        if(options == null){
            options = new ArrayList<>();
            options.add("java");

        }

        if(options != null){
            for(String a : options){
                if(a.equals("java")){
                    logger.info(">>>>>>>>>>>>> i found java");
                }
                if(a.equals("c++")){
                    logger.info(">>>>>>>>>>>>> i found c++");
                }
                if(a.equals("python")){
                    logger.info(">>>>>>>>>>>>> i found python");
                }

            }
        }

        FormModelAttribute formModelAttribute = new FormModelAttribute(naam, bedrijf, startdatum, einddatum, options);
        model.addAttribute("formModelAttribute", formModelAttribute);


        return "form";
    }

    @PostMapping("/form")
    public String formProcessing(@ModelAttribute(name="formModelAttribute") FormModelAttribute formModelAttribute,
                                 RedirectAttributes redirectAttributes){
        redirectAttributes.addAttribute("naam", formModelAttribute.getNaam());
        redirectAttributes.addAttribute("bedrijf", formModelAttribute.getBedrijf());
        redirectAttributes.addAttribute("startdatum", formModelAttribute.getStartdatum());
        redirectAttributes.addAttribute("einddatum", formModelAttribute.getEinddatum());
        redirectAttributes.addAttribute("options", formModelAttribute.getOptions());


        return "redirect:/form";
    }
}
