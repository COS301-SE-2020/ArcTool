package com.arcTool.ExtractorInterface;

import com.arcTool.Controller.JsoupExtractor.ExtractorController;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExtractorInterface extends JpaRepository<ExtractorController,String> {
}
