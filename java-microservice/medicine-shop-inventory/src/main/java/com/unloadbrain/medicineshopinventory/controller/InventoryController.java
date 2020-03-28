package com.unloadbrain.medicineshopinventory.controller;

import com.unloadbrain.medicineshopinventory.dto.request.ProductCreateRequest;
import com.unloadbrain.medicineshopinventory.service.InventoryService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
@AllArgsConstructor
public class InventoryController {

    private final InventoryService inventoryService;

    @GetMapping("/admin/inventory/list")
    public String showProductInventoryList(Model model, Pageable pageable) {
        model.addAttribute("products", inventoryService.listByPage(pageable));
        return "admin/productListPage";
    }

    @GetMapping("/admin/inventory")
    public String showCreateProductForm(Model model) {
        model.addAttribute("productCreateRequest", new ProductCreateRequest());
        return "admin/addProductPage";
    }

    @PostMapping("/admin/inventory")
    public String createProduct(@ModelAttribute @Valid ProductCreateRequest productCreateRequest,
                                BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "admin/addProductPage";
        }

        inventoryService.create(productCreateRequest);
        return "redirect:/admin/inventory/list";
    }

}
