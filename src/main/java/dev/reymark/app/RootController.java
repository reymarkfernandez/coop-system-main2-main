package dev.reymark.app;

import dev.reymark.App;
import dev.reymark.data.MemberDAO;
import dev.reymark.models.enums.CivilStatus;
import dev.reymark.models.hr.Member;
import dev.sol.core.application.FXController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class RootController extends FXController {

    @FXML
    private TableView<Member> memberTable;

    @FXML
    private TableColumn<Member, String> memberIdColumn;

    @FXML
    private TableColumn<Member, String> lnameColumn;

    @FXML
    private TableColumn<Member, String> fnameColumn;

    @FXML
    private TableColumn<Member, Long> amountpaidColumn;

    @FXML
    private TextField firstname;

    @FXML
    private TextField middlename;

    @FXML
    private TextField lastname;

    @FXML
    private TextField birthdate;

    @FXML
    private TextField birthplace;

    @FXML
    private ComboBox<Member> civilstatus;

    @FXML
    private TextField homeaddress;

    @FXML
    private TextField occupation;

    @FXML
    private ComboBox<Member> officeid;

    @FXML
    private TextField salary;

    @FXML
    private TextField income;

    @FXML
    private TextField relativefield;

    @FXML
    private ComboBox<Member> relationfield;

    @FXML
    private TextField dependents;

    @FXML
    private TextField stockshare;

    @FXML
    private TextField stockamount;

    @FXML
    private TextField stockpaid;

    @FXML
    private TextField amountpaid;

    @FXML
    private TextField search;

    @FXML
    private void handleDelete() {
        Member selectedMember = memberTable.getSelectionModel().getSelectedItem();
        if (memberTable.getSelectionModel().getSelectedItem() == null) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Member Delete Error");
            alert.setHeaderText("Null Selection Error Occurred");
            alert.setContentText("No Member selected from table. Must select a Member to delete");
            alert.initOwner(scene.getWindow());
            alert.show();
            return;
        }
        member_masterlist.remove(selectedMember);
        MemberDAO.delete(selectedMember);

    }

    private Member selectedmember;
    private Scene scene;
    private ObservableList<Member> member_masterlist;
    private FilteredList<Member> memberFilteredList;

    @Override
    protected void load_fields() {
        _bind_labelProperties();

    }

    @Override
    protected void load_bindings() {
        scene = (Scene) getParameter("SCENE");
        member_masterlist = App.COLLECTIONS_REGISTER.getList("MEMBER");
        memberFilteredList = new FilteredList<>(member_masterlist, p -> true);

        memberIdColumn.setCellValueFactory(cell -> cell.getValue().memberIDProperty().asString());
        lnameColumn.setCellValueFactory(cell -> cell.getValue().lnameProperty());
        fnameColumn.setCellValueFactory(cell -> cell.getValue().fnameProperty());
        amountpaidColumn.setCellValueFactory(cell -> cell.getValue().amountPaidProperty().asObject());

        ObservableList<CivilStatus> joblist = FXCollections.observableArrayList(CivilStatus.values());
        if (member_masterlist.stream().anyMatch(e -> e.getCivil_Status().equals(CivilStatus.SINGLE))) {
            // civilstatus.setItems(FXCollections.observableArrayList(joblist.subList(0,
            // joblist.size())));
        } else
            // civilstatus.setItems(joblist);

            memberTable.setItems(member_masterlist);
    }

    @Override
    protected void load_listeners() {
        memberTable.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            selectedmember = newValue;
            _bind_labelProperties();
        });

    }

    private void _bind_labelProperties() {
        if (selectedmember != null) {
            firstname.textProperty().bind(selectedmember.fnameProperty());
            lastname.textProperty().bind(selectedmember.lnameProperty());
            middlename.textProperty().bind(selectedmember.mnameProperty());
            birthdate.textProperty().bind(selectedmember.birthDateProperty());
            birthplace.textProperty().bind(selectedmember.birthplaceProperty());
            // civilstatus.valueProperty().bind(selectedmember.civil_statusProperty());
            homeaddress.textProperty().bind(selectedmember.homeAddressProperty());
            occupation.textProperty().bind(selectedmember.occupationProperty());
            // officeid.valueProperty().bind(selectedmember.officeProperty());
            // salary.textProperty().bind(selectedmember.salaryProperty());
            income.textProperty().bind(selectedmember.sourceofincomeProperty());
            relativefield.textProperty().bind(selectedmember.relativeProperty());
            // relationship.textProperty().bind(selectedmember.relationshipProperty());
            dependents.textProperty().bind(selectedmember.dependentProperty());
            // stockshare.textProperty().bind(selectedmember.stockshareProperty());
            // stockamount.textProperty().bind(selectedmember.stockamountProperty());
            // stockpaid.textProperty().bind(selectedmember.stockpaidProperty());
            // amountpaid.LongProperty().bind(selectedmember.amountPaidProperty());

        }
    }

    private void reset_combobox() {

        civilstatus.getSelectionModel().selectFirst();

    }

}
