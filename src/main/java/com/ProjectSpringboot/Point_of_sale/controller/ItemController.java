package com.ProjectSpringboot.Point_of_sale.controller;

import com.ProjectSpringboot.Point_of_sale.dto.request.ItemDTO;
import com.ProjectSpringboot.Point_of_sale.dto.response.ItemGetResponseDTO;
import com.ProjectSpringboot.Point_of_sale.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;

@RestController
@CrossOrigin
@RequestMapping("api/v1/item")
public class ItemController {
    @Autowired
    private ItemService itemService;

    @PostMapping("/save")
    public String saveItem(@RequestBody ItemDTO itemDTO) {
       itemService.saveItem(itemDTO);
        return "Saved Item Successfully";
    }


    @GetMapping(
            path = "/get-by-name",
            params = "name"
    )
    public ResponseEntity<Object> getItemByNameAndStatus(@RequestParam(value = "name") String itemName) {
        List<ItemGetResponseDTO> itemDTOs = itemService.getItemByNameAndStatus(itemName);
        System.out.println("Fetching items with name: " + itemName);
        if (itemDTOs.isEmpty()) {
            return ResponseEntity.status(404).body(
                    Map.of("message", "No items found with name: " + itemName)
            );
        }
        return ResponseEntity.ok(itemDTOs);
    }

    @PatchMapping("/update-active-state/{itemId}")
    public ResponseEntity<Object> updateActiveState(
            @PathVariable String itemId,
            @RequestParam boolean activeState) {
        String result = itemService.updateActiveState(itemId, activeState);
        if (result.startsWith("Item not found")) {
            return ResponseEntity.status(404).body(
                    Map.of("message", result)
            );
        }
        return ResponseEntity.ok(Map.of("message", result));
    }


}
