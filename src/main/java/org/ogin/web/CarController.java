package org.ogin.web;

import org.ogin.dao.CarDao;
import org.ogin.domain.Car;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author ogin
 */
@Controller
@RequestMapping("/car")
public class CarController {
    private Logger logger = LoggerFactory.getLogger(CarController.class);
    @Autowired
    private CarDao carDao;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(Model model) {
        Car car = new Car();
        model.addAttribute("car", car);
        return "car/index";
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String list(Model model) {
        List<Car> cars = carDao.getCars();
        model.addAttribute("cars", cars);
        return "car/list";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(final Car car, BindingResult bindingResult, ModelMap model) {
        if (bindingResult.hasErrors()) {
            return "car/index";
        }

       /* model.addAttribute("id", car.getId());
        model.addAttribute("company", car.getCompany());
        model.addAttribute("model", car.getModel());
        model.addAttribute("price", car.getPrice());*/
        carDao.persist(car);
        model.clear();
        return "redirect:/car/list";

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


