package org.equivalencia.controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import org.equivalencia.model.Materia;
import org.equivalencia.model.MateriaOfertada;
import org.equivalencia.service.MainService;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.SingleSelectionModel;
import javafx.scene.control.TextArea;

public class MainController implements Initializable{
	
	private MainService mainService = new MainService();

	private List<Materia> materias = new ArrayList<>();
	
	private ObservableList<Materia> obMaterias;
	
	private ObservableList<MateriaOfertada> obMateriaOfertada;
	
	@FXML
    private ListView<MateriaOfertada> listViewId;

    @FXML
    private ComboBox<Materia> comboBoxId;

    @FXML
    private TextArea textFieldId;
    
    @FXML
    private ListView<MateriaOfertada> lvMateriasOfSalvas;

    @FXML
    private TextArea tfEquivalencias;
    
    @FXML
    private ComboBox<Materia> materiasSalvasId;

    

    @FXML
    public void cbSelect() {
    	//Pega materia selecionada no comboBox
    	SingleSelectionModel<Materia> materiaSelect = comboBoxId.getSelectionModel();
    	Materia materia = materiaSelect.getSelectedItem();
    	//textFieldId.setText(materia.getEmenta());
    	
    	List<MateriaOfertada> materiasOfertadas = materia.getMateriasOfertadas();
    	materia.setMateriasOfertadas(materiasOfertadas);
    	obMateriaOfertada = FXCollections.observableArrayList(materiasOfertadas);
    	
    	listViewId.setItems(obMateriaOfertada);
    }
    
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		this.materias = mainService.carregarMaterias();
		
		obMaterias = FXCollections.observableArrayList(materias);
		comboBoxId.setItems(obMaterias);
		
	}
}
