package magazyn;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Popup;
import magazyn.lab2.FulfillmentCenter;
import magazyn.lab2.Item;
import magazyn.lab2.ItemCondition;

import java.util.List;
import java.util.stream.Collectors;

import static magazyn.InitializationData.fulfillmentCenterContainer;

public class Controller {

    @FXML
    private ComboBox<String> magazines;

    @FXML
    private TableView<TableRowDto> tableView;

    @FXML
    private TableColumn<TableRowDto, String> nameColumn;

    @FXML
    private TableColumn<TableRowDto, ItemCondition> conditionColumn;

    @FXML
    private TableColumn<TableRowDto, String> fulfillmentCenterNameColumn;

    @FXML
    private TableColumn<TableRowDto, Integer> countColumn;

    @FXML
    private TextField searchField;

    @FXML
    private TextField countToBuyField;


    @FXML
    public void initialize() {
        InitializationData.initialize();
        setUpMagazines();
        magazines.setValue("dowolny");

        setTableView(initialTableState());
    }


    @FXML
    public void filterAction() {
        ObservableList<TableRowDto> tableRows;

        if (magazines.getValue().equals("dowolny") || magazines.getValue() == null) tableRows = initialTableState();
        else tableRows = filter(magazines.getValue());

        setTableView(tableRows);
    }

    @FXML
    public void buyAction() {
        TableRowDto selectedRow = tableView.getSelectionModel().getSelectedItem();
        String countToBuy = countToBuyField.getText();

        if(selectedRow == null || countToBuy.equals("")) {
            displayAlert("Nie wybrano przedmiotu lub nie podano ilości!");
            return;
        }

        FulfillmentCenter fulfillmentCenter = fulfillmentCenterContainer.getMagazinesMap().get(selectedRow.getFulfillmentCenterName());
        Item itemToRemove = fulfillmentCenter.search(selectedRow.getItemName());

        try {
            fulfillmentCenter.removeProduct(itemToRemove, Integer.parseInt(countToBuy));
        } catch (RuntimeException ex) {
            displayAlert(ex.getMessage());
            return;
        }
        filterAction();
    }

    private void displayAlert(String s) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION, s);
        alert.showAndWait();
    }

    private ObservableList<TableRowDto> filter(String centerName) {
        ObservableList<TableRowDto> tableRows = FXCollections.observableArrayList();
        fulfillmentCenterContainer.getMagazinesMap().forEach((k, v) -> {
            if (centerName.equals(k)) {
                v.getProductsList().forEach(x -> {
                    TableRowDto tableRow = new TableRowDto(k, v.getMagazineCapacity(), x.getName(), x.getCount(), x.getCondition());
                    tableRows.add(tableRow);
                });
            }
        });
        return filterByItemName(tableRows);
    }

    private ObservableList<TableRowDto> initialTableState() {
        ObservableList<TableRowDto> tableRows = FXCollections.observableArrayList();

        fulfillmentCenterContainer.getMagazinesMap().forEach((k, v) ->
                v.getProductsList().forEach(x -> {
                    TableRowDto tableRow = new TableRowDto(k, v.getMagazineCapacity(), x.getName(), x.getCount(), x.getCondition());
                    tableRows.add(tableRow);
                })
        );
        return filterByItemName(tableRows);
    }

    private ObservableList<TableRowDto> filterByItemName(ObservableList<TableRowDto> filteredByMagazine) {
        if (!searchField.getText().equals("")) {
            return FXCollections.observableArrayList(
                    filteredByMagazine.stream()
                            .filter(tableRowDTO -> tableRowDTO.getItemName().equals(searchField.getText()))
                            .collect(Collectors.toList()));
        }
        return filteredByMagazine;
    }

    private void setTableView(ObservableList<TableRowDto> tableRows) {
        tableView.setItems(tableRows);
        setUpTooltip();


        nameColumn.setCellValueFactory(new PropertyValueFactory<>("fulfillmentCenterName"));
        conditionColumn.setCellValueFactory(new PropertyValueFactory<>("itemName"));
        fulfillmentCenterNameColumn.setCellValueFactory(new PropertyValueFactory<>("count"));
        countColumn.setCellValueFactory(new PropertyValueFactory<>("itemCondition"));

        Tooltip.install(nameColumn.getSortNode(), new Tooltip("dupa"));
    }


    private void setUpTooltip() {
        tableView.setRowFactory(tv -> new TableRow<TableRowDto>() {
            private Tooltip tooltip = new Tooltip();

            @Override
            public void updateItem(TableRowDto tableRowDTO, boolean empty) {
                super.updateItem(tableRowDTO, empty);
                if (tableRowDTO == null) {
                    setTooltip(null);
                } else {
                    tooltip.setText("Pojemność magazynu " + tableRowDTO.getFulfillmentCenterName() + " wynosi: " + tableRowDTO.getWeight());
                    setTooltip(tooltip);
                }
            }
        });
    }

    private void setUpMagazines() {
        List<String> magazinesNames = fulfillmentCenterContainer.getMagazinesNames();
        magazinesNames.add("dowolny");
        magazines.setItems(FXCollections.observableArrayList(magazinesNames));
    }
}
