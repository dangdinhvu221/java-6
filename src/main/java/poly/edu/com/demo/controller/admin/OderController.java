package poly.edu.com.demo.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import poly.edu.com.demo.entity.Orders;
import poly.edu.com.demo.service.*;

import java.util.List;

@Controller
@RequestMapping("/earPhone/dashAdmin")
public class OderController {

    @Autowired
    private OrderService orderService;
    @Autowired
    private OrderDetailService detailsService;
    @Autowired
    private EarPhoneService earPhoneService;
    @Autowired
    private CartService cartService;
    @Autowired
    private OrderStatesService statesService;


    @GetMapping("/Orders/updateOrders")
    public String updateOrders(
            @RequestParam("checkedID") Long[] id,
            @RequestParam("orderStates") Long idStates
    ){
        List<Orders> list = this.orderService.getAllOrders();
        for (Orders o : list){
            for (Long idO : id){
                if(o.getId().equals(idO)){
                    this.orderService.updateOrders(o.getId(), idStates);
                }
            }
        }
        return "redirect:/earPhone/dashAdmin/manageOrders";
    }

    @GetMapping("/manageOrders")
    public String manageOrder(ModelMap model) {
        return findPaginated(1, model);
    }


    @GetMapping("/Orders/searchOrders")
    public String searchManufacturers(@RequestParam("search") Long id,
                                      ModelMap model
    ) {
        model.addAttribute("ListOrders", this.orderService.getOrders(id));
        Page<Orders> pageOrders = orderService.findPaginated(1, 5);
        model.addAttribute("page", pageOrders);
        model.addAttribute("currentPage", 1);
        this.actions(model);
        return "dashAdmin/fragments/manage-Orders";
    }

    @GetMapping("/Orders/pageOrders/{pageNo}")
    public String findPaginated(@PathVariable("pageNo") int pageNo, ModelMap model) {
        int pageSize = 5;
        Page<Orders> pageOrders = orderService.findPaginated(pageNo, pageSize);

        model.addAttribute("ListOrders", pageOrders.getContent());
        model.addAttribute("page", pageOrders);
        model.addAttribute("currentPage", pageNo);
        this.actions(model);
        return "dashAdmin/fragments/manage-Orders";
    }

    public void actions(ModelMap model) {
        model.addAttribute("listOrderDetails", this.detailsService.getAllOrderDetails());
        model.addAttribute("listOrderStates", this.statesService.getAllOrderStates());
        model.addAttribute("SEARCH", "/searchOrders");
        model.addAttribute("BASEURL", "/earPhone/dashAdmin/Orders");
        model.addAttribute("UPDATE", "/updateOrders");
        model.addAttribute("DELETE_ALL", "/earPhone/dashAdmin/Orders/deleteOrders");
        model.addAttribute("PAGE", "/pageOrders/");
    }

}
