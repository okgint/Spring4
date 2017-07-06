package org.ogin.web;

import org.ogin.dao.ManufacturerDao;
import org.ogin.dao.ModelDao;
import org.ogin.domain.Manufacturer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author ogin
 */
@Controller
@RequestMapping("/model")
public class ModelController {
    private Logger logger = LoggerFactory.getLogger(ModelController.class);
    @Autowired
    private ModelDao modelDao;
    @Autowired
    private ManufacturerDao manufacturerDao;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(Model model) {
        org.ogin.domain.Model modelku = new org.ogin.domain.Model();
        model.addAttribute("model", modelku);
//        model.addAttribute("manufacturer", manufacturerDao.getManufacturers());
        return "model/index";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(    @RequestParam(value="id", required=true) int id,
                           final org.ogin.domain.Model model, BindingResult bindingResult, ModelMap modelMap) {
        logger.info("--Save--");
        String name = model.getName();
        logger.info("Name : " + name);
        logger.info("id : " + id);
        Manufacturer manufacturer = manufacturerDao.getManufacturer(id);
        modelDao.persist(name, manufacturer);
        return "redirect:/model/list";
    }

    @RequestMapping(value="/list", method=RequestMethod.GET)
    public String list(Model model) {
        List<org.ogin.domain.Model> models = modelDao.getModel();
        model.addAttribute("models", models);
        return "model/list";
    }

    @ModelAttribute("manufacturers")
    public List<Manufacturer> populateTypes() {
        return manufacturerDao.getManufacturers();
    }
    @ExceptionHandler(Exception.class)
    public ModelAndView handleError(HttpServletRequest req, Exception ex) {
        logger.error("Request: " + req.getRequestURL() + " raised " + ex);

        ModelAndView mav = new ModelAndView();
        mav.addObject("exception", ex);
        mav.addObject("url", req.getRequestURL());
        mav.setViewName("error/error");
        return mav;
    }
}
