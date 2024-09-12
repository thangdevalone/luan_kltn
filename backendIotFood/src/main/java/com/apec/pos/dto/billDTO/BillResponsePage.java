package com.apec.pos.dto.billDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BillResponsePage {
    private int totalRow;
    private List<BillResponse> data;
}
