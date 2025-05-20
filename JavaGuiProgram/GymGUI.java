import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;

public class GymGUI {
    private JFrame frame;

    // Navigation buttons
    private JButton regularMemberRegistration, premiumMemberRegistration, manageRegular, managePremium;

    // Panels (all inside GymGUI)
    private JPanel regularMemberRegistrationPanel;
    private JPanel premiumMemberRegistrationPanel;
    private JPanel manageRegularPanel;
    private JPanel managePremiumPanel;

    // Member list (shared)
    public static ArrayList<GymMember> memberList = new ArrayList<>();

    // Components for RegularMemberRegistrationPanel
    private JLabel titleLabel, personalInfoLabel, idLabel, nameLabel, phoneLabel, locationLabel, emailLabel, dobLabel, genderLabel;
    private JTextField idText, nameText, phoneText, locationText, emailText;
    private JComboBox<String> yearCombobox, monthCombobox, dayCombobox;
    private JRadioButton male, female;
    private JButton addRegularButton, clearRegularButton, readRegularButton, saveRegularButton, displayRegularButton;
    private ButtonGroup genderGroupRegular;

    // Components for PremiumMemberRegistrationPanel
    private JLabel titleLabelPremium, personalInfoLabelPremium, idLabelPremium, nameLabelPremium, phoneLabelPremium, locationLabelPremium, emailLabelPremium, dobLabelPremium, genderLabelPremium, membershipDetailsLabel, startDateLabel, trainerLabel;
    private JTextField idTextPremium, nameTextPremium, phoneTextPremium, locationTextPremium, emailTextPremium, trainerText;
    private JComboBox<String> yearComboboxPremium, monthComboboxPremium, dayComboboxPremium, startYearBox, startMonthBox, startDayBox;
    private JRadioButton malePremium, femalePremium;
    private JButton addPremiumButton, clearPremiumButton, readPremiumButton, savePremiumButton, displayPremiumButton;
    private ButtonGroup genderGroupPremium;

    // Components for ManageRegularPanel
    private JLabel titleLabelRegular, idLabelManageRegular, titleLabelGymUpgrade, gymPlanLabel, titleLabelRevertMembership, removalReasonLabel;
    private JTextField idTextManageRegular, removalReasonText;
    private JComboBox<String> gymPlanCombobox;
    private JButton markAttendanceButton, activateMembershipButton, deactivateMembershipButton, upgradePlanButton, revertButton;
    private JButton readFromFileButtonManageRegular, saveButtonManageRegular, displayButtonManageRegular, clearButtonManageRegular;

    // Components for ManagePremiumPanel (if any, you must add similarly)

    public GymGUI() {
        frame = new JFrame("Gym Membership Management");
        frame.setSize(1000, 700);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        // --- Navigation buttons ---
        regularMemberRegistration = new JButton("Regular Member Registration");
        regularMemberRegistration.setBounds(50, 20, 220, 30);
        frame.add(regularMemberRegistration);

        premiumMemberRegistration = new JButton("Premium Member Registration");
        premiumMemberRegistration.setBounds(280, 20, 220, 30);
        frame.add(premiumMemberRegistration);

        manageRegular = new JButton("Manage Regular Member");
        manageRegular.setBounds(510, 20, 200, 30);
        frame.add(manageRegular);

        managePremium = new JButton("Manage Premium Member");
        managePremium.setBounds(720, 20, 200, 30);
        frame.add(managePremium);

        // --- Panels ---
        initRegularMemberRegistrationPanel();
        initPremiumMemberRegistrationPanel();
        initManageRegularPanel();
        initManagePremiumPanel();

        // Add all panels to frame (only one visible at start)
        frame.add(regularMemberRegistrationPanel);
        frame.add(premiumMemberRegistrationPanel);
        frame.add(manageRegularPanel);
        frame.add(managePremiumPanel);

        // Show only Regular Member Registration panel initially
        showPanel(regularMemberRegistrationPanel);

        // Navigation buttons logic to switch panels
        regularMemberRegistration.addActionListener(e -> showPanel(regularMemberRegistrationPanel));
        premiumMemberRegistration.addActionListener(e -> showPanel(premiumMemberRegistrationPanel));
        manageRegular.addActionListener(e -> showPanel(manageRegularPanel));
        managePremium.addActionListener(e -> showPanel(managePremiumPanel));

        frame.setVisible(true);
    }

    private void showPanel(JPanel panelToShow) {
        regularMemberRegistrationPanel.setVisible(false);
        premiumMemberRegistrationPanel.setVisible(false);
        manageRegularPanel.setVisible(false);
        managePremiumPanel.setVisible(false);

        panelToShow.setVisible(true);
    }

    private void initRegularMemberRegistrationPanel() {
        regularMemberRegistrationPanel = new JPanel();
        regularMemberRegistrationPanel.setLayout(null);
        regularMemberRegistrationPanel.setBounds(0, 70, 1000, 630);

        titleLabel = new JLabel("Add a new Regular Member");
        titleLabel.setBounds(350, 20, 300, 30);
        titleLabel.setFont(titleLabel.getFont().deriveFont(18.0f));
        regularMemberRegistrationPanel.add(titleLabel);

        personalInfoLabel = new JLabel("Personal Information");
        personalInfoLabel.setBounds(50, 60, 200, 30);
        personalInfoLabel.setFont(personalInfoLabel.getFont().deriveFont(16.0f));
        regularMemberRegistrationPanel.add(personalInfoLabel);

        idLabel = new JLabel("Member ID:");
        idLabel.setBounds(50, 100, 100, 25);
        idText = new JTextField();
        idText.setBounds(130, 100, 120, 25);
        regularMemberRegistrationPanel.add(idLabel);
        regularMemberRegistrationPanel.add(idText);

        nameLabel = new JLabel("Name:");
        nameLabel.setBounds(280, 100, 60, 25);
        nameText = new JTextField();
        nameText.setBounds(330, 100, 150, 25);
        regularMemberRegistrationPanel.add(nameLabel);
        regularMemberRegistrationPanel.add(nameText);

        phoneLabel = new JLabel("Phone:");
        phoneLabel.setBounds(500, 100, 60, 25);
        phoneText = new JTextField();
        phoneText.setBounds(560, 100, 150, 25);
        regularMemberRegistrationPanel.add(phoneLabel);
        regularMemberRegistrationPanel.add(phoneText);

        locationLabel = new JLabel("Location:");
        locationLabel.setBounds(50, 140, 100, 25);
        locationText = new JTextField();
        locationText.setBounds(130, 140, 150, 25);
        regularMemberRegistrationPanel.add(locationLabel);
        regularMemberRegistrationPanel.add(locationText);

        emailLabel = new JLabel("Email:");
        emailLabel.setBounds(300, 140, 60, 25);
        emailText = new JTextField("xyz123@gmail.com");
        emailText.setBounds(360, 140, 350, 25);
        regularMemberRegistrationPanel.add(emailLabel);
        regularMemberRegistrationPanel.add(emailText);

        String[] years = new String[2025 - 1990 + 1];
        for (int i = 0; i < years.length; i++) {
            years[i] = String.valueOf(1990 + i);
        }

        String[] months = new String[]{
            "January", "February", "March", "April", "May", "June",
            "July", "August", "September", "October", "November", "December"
        };

        String[] days = new String[31];
        for (int i = 0; i < 31; i++) {
            days[i] = String.valueOf(i + 1);
        }

        dobLabel = new JLabel("DOB:");
        dobLabel.setBounds(50, 180, 60, 25);
        yearCombobox = new JComboBox<>(years);
        yearCombobox.setBounds(100, 180, 80, 25);
        monthCombobox = new JComboBox<>(months);
        monthCombobox.setBounds(190, 180, 100, 25);
        dayCombobox = new JComboBox<>(days);
        dayCombobox.setBounds(300, 180, 80, 25);
        regularMemberRegistrationPanel.add(dobLabel);
        regularMemberRegistrationPanel.add(yearCombobox);
        regularMemberRegistrationPanel.add(monthCombobox);
        regularMemberRegistrationPanel.add(dayCombobox);

        genderLabel = new JLabel("Gender:");
        genderLabel.setBounds(400, 180, 60, 25);
        male = new JRadioButton("Male");
        male.setBounds(470, 180, 60, 25);
        male.setActionCommand("Male");
        female = new JRadioButton("Female");
        female.setBounds(540, 180, 70, 25);
        female.setActionCommand("Female");
        genderGroupRegular = new ButtonGroup();
        genderGroupRegular.add(male);
        genderGroupRegular.add(female);
        regularMemberRegistrationPanel.add(genderLabel);
        regularMemberRegistrationPanel.add(male);
        regularMemberRegistrationPanel.add(female);

        addRegularButton = new JButton("ADD AS REGULAR MEMBER");
        addRegularButton.setBounds(50, 500, 200, 30);
        regularMemberRegistrationPanel.add(addRegularButton);

        clearRegularButton = new JButton("CLEAR");
        clearRegularButton.setBounds(260, 500, 100, 30);
        regularMemberRegistrationPanel.add(clearRegularButton);

        readRegularButton = new JButton("Read from File");
        readRegularButton.setBounds(370, 500, 150, 30);
        regularMemberRegistrationPanel.add(readRegularButton);

        saveRegularButton = new JButton("Save to File");
        saveRegularButton.setBounds(530, 500, 150, 30);
        regularMemberRegistrationPanel.add(saveRegularButton);

        displayRegularButton = new JButton("Display");
        displayRegularButton.setBounds(690, 500, 150, 30);
        regularMemberRegistrationPanel.add(displayRegularButton);

        // Action listeners (unchanged)
        addRegularButton.addActionListener(e -> {
            String idStore = idText.getText().trim();
            String name = nameText.getText().trim();
            String phone = phoneText.getText().trim();
            String email = emailText.getText().trim();
            String location = locationText.getText().trim();

            if (genderGroupRegular.getSelection() == null) {
                JOptionPane.showMessageDialog(frame, "Please select a gender.");
                return;
            }
            String gender = genderGroupRegular.getSelection().getActionCommand();

            String birthYear = (String) yearCombobox.getSelectedItem();
            String birthMonth = (String) monthCombobox.getSelectedItem();
            String birthDay = (String) dayCombobox.getSelectedItem();
            String dobValue = birthYear + "/" + birthMonth + "/" + birthDay;

            int id;
            try {
                id = Integer.parseInt(idStore);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame, "Enter a valid/unique ID.");
                return;
            }

            for (GymMember member : memberList) {
                if (member.getId() == id) {
                    JOptionPane.showMessageDialog(frame, "Enter a unique ID.");
                    return;
                }
            }

            try {
                int ph = Integer.parseInt(phone);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame, "Enter a valid phone number.");
                return;
            }

            if (name.isEmpty() || phone.isEmpty() || email.isEmpty() || location.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Please fill out all the given fields.");
                return;
            }

            RegularMember newMember = new RegularMember(id, name, location, phone, email, gender, dobValue);
            JOptionPane.showMessageDialog(frame, "Member has been successfully added.");
            memberList.add(newMember);
        });

        clearRegularButton.addActionListener(e -> {
            idText.setText("");
            nameText.setText("");
            phoneText.setText("");
            locationText.setText("");
            emailText.setText("xyz123@gmail.com");
            genderGroupRegular.clearSelection();
            yearCombobox.setSelectedIndex(0);
            monthCombobox.setSelectedIndex(0);
            dayCombobox.setSelectedIndex(0);
        });
    }

    private void initPremiumMemberRegistrationPanel() {
        premiumMemberRegistrationPanel = new JPanel();
        premiumMemberRegistrationPanel.setLayout(null);
        premiumMemberRegistrationPanel.setBounds(0, 70, 1000, 630);
            titleLabelPremium = new JLabel("Add a new Premium Member");
    titleLabelPremium.setBounds(350, 20, 300, 30);
    titleLabelPremium.setFont(titleLabelPremium.getFont().deriveFont(18.0f));
    premiumMemberRegistrationPanel.add(titleLabelPremium);

    personalInfoLabelPremium = new JLabel("Personal Information");
    personalInfoLabelPremium.setBounds(50, 60, 200, 30);
    personalInfoLabelPremium.setFont(personalInfoLabelPremium.getFont().deriveFont(16.0f));
    premiumMemberRegistrationPanel.add(personalInfoLabelPremium);

    idLabelPremium = new JLabel("Member ID:");
    idLabelPremium.setBounds(50, 100, 100, 25);
    idTextPremium = new JTextField();
    idTextPremium.setBounds(130, 100, 120, 25);
    premiumMemberRegistrationPanel.add(idLabelPremium);
    premiumMemberRegistrationPanel.add(idTextPremium);

    nameLabelPremium = new JLabel("Name:");
    nameLabelPremium.setBounds(280, 100, 60, 25);
    nameTextPremium = new JTextField();
    nameTextPremium.setBounds(330, 100, 150, 25);
    premiumMemberRegistrationPanel.add(nameLabelPremium);
    premiumMemberRegistrationPanel.add(nameTextPremium);

    phoneLabelPremium = new JLabel("Phone:");
    phoneLabelPremium.setBounds(500, 100, 60, 25);
    phoneTextPremium = new JTextField();
    phoneTextPremium.setBounds(560, 100, 150, 25);
    premiumMemberRegistrationPanel.add(phoneLabelPremium);
    premiumMemberRegistrationPanel.add(phoneTextPremium);

    locationLabelPremium = new JLabel("Location:");
    locationLabelPremium.setBounds(50, 140, 100, 25);
    locationTextPremium = new JTextField();
    locationTextPremium.setBounds(130, 140, 150, 25);
    premiumMemberRegistrationPanel.add(locationLabelPremium);
    premiumMemberRegistrationPanel.add(locationTextPremium);

    emailLabelPremium = new JLabel("Email:");
    emailLabelPremium.setBounds(300, 140, 60, 25);
    emailTextPremium = new JTextField("xyz123@gmail.com");
    emailTextPremium.setBounds(360, 140, 350, 25);
    premiumMemberRegistrationPanel.add(emailLabelPremium);
    premiumMemberRegistrationPanel.add(emailTextPremium);

    String[] years = new String[2025 - 1990 + 1];
    for (int i = 0; i < years.length; i++) {
        years[i] = String.valueOf(1990 + i);
    }

    String[] months = new String[]{
        "January", "February", "March", "April", "May", "June",
        "July", "August", "September", "October", "November", "December"
    };

    String[] days = new String[31];
    for (int i = 0; i < 31; i++) {
        days[i] = String.valueOf(i + 1);
    }

    dobLabelPremium = new JLabel("DOB:");
    dobLabelPremium.setBounds(50, 180, 60, 25);
    yearComboboxPremium = new JComboBox<>(years);
    yearComboboxPremium.setBounds(100, 180, 80, 25);
    monthComboboxPremium = new JComboBox<>(months);
    monthComboboxPremium.setBounds(190, 180, 100, 25);
    dayComboboxPremium = new JComboBox<>(days);
    dayComboboxPremium.setBounds(300, 180, 80, 25);
    premiumMemberRegistrationPanel.add(dobLabelPremium);
    premiumMemberRegistrationPanel.add(yearComboboxPremium);
    premiumMemberRegistrationPanel.add(monthComboboxPremium);
    premiumMemberRegistrationPanel.add(dayComboboxPremium);

    genderLabelPremium = new JLabel("Gender:");
    genderLabelPremium.setBounds(400, 180, 60, 25);
    malePremium = new JRadioButton("Male");
    malePremium.setBounds(470, 180, 60, 25);
    malePremium.setActionCommand("Male");
    femalePremium = new JRadioButton("Female");
    femalePremium.setBounds(540, 180, 70, 25);
    femalePremium.setActionCommand("Female");
    genderGroupPremium = new ButtonGroup();
    genderGroupPremium.add(malePremium);
    genderGroupPremium.add(femalePremium);
    premiumMemberRegistrationPanel.add(genderLabelPremium);
    premiumMemberRegistrationPanel.add(malePremium);
    premiumMemberRegistrationPanel.add(femalePremium);

    membershipDetailsLabel = new JLabel("Membership Details");
    membershipDetailsLabel.setBounds(50, 220, 200, 30);
    membershipDetailsLabel.setFont(membershipDetailsLabel.getFont().deriveFont(16.0f));
    premiumMemberRegistrationPanel.add(membershipDetailsLabel);

    startDateLabel = new JLabel("Start Date:");
    startDateLabel.setBounds(50, 260, 100, 25);
    premiumMemberRegistrationPanel.add(startDateLabel);

    startYearBox = new JComboBox<>(years);
    startYearBox.setBounds(130, 260, 80, 25);
    premiumMemberRegistrationPanel.add(startYearBox);

    startMonthBox = new JComboBox<>(months);
    startMonthBox.setBounds(220, 260, 100, 25);
    premiumMemberRegistrationPanel.add(startMonthBox);

    startDayBox = new JComboBox<>(days);
    startDayBox.setBounds(330, 260, 80, 25);
    premiumMemberRegistrationPanel.add(startDayBox);

    trainerLabel = new JLabel("Trainer Name:");
    trainerLabel.setBounds(50, 300, 100, 25);
    premiumMemberRegistrationPanel.add(trainerLabel);

    trainerText = new JTextField();
    trainerText.setBounds(150, 300, 200, 25);
    premiumMemberRegistrationPanel.add(trainerText);

    addPremiumButton = new JButton("ADD AS PREMIUM MEMBER");
    addPremiumButton.setBounds(50, 500, 230, 30);
    premiumMemberRegistrationPanel.add(addPremiumButton);

    clearPremiumButton = new JButton("CLEAR");
    clearPremiumButton.setBounds(290, 500, 100, 30);
    premiumMemberRegistrationPanel.add(clearPremiumButton);

    readPremiumButton = new JButton("Read from File");
    readPremiumButton.setBounds(400, 500, 150, 30);
    premiumMemberRegistrationPanel.add(readPremiumButton);

    savePremiumButton = new JButton("Save to File");
    savePremiumButton.setBounds(560, 500, 150, 30);
    premiumMemberRegistrationPanel.add(savePremiumButton);

    displayPremiumButton = new JButton("Display");
    displayPremiumButton.setBounds(720, 500, 150, 30);
    premiumMemberRegistrationPanel.add(displayPremiumButton);

    addPremiumButton.addActionListener(e -> {
        String idStore = idTextPremium.getText().trim();
        String name = nameTextPremium.getText().trim();
        String phone = phoneTextPremium.getText().trim();
        String email = emailTextPremium.getText().trim();
        String location = locationTextPremium.getText().trim();
        String trainerName = trainerText.getText().trim();

        if (genderGroupPremium.getSelection() == null) {
            JOptionPane.showMessageDialog(frame, "Please select a gender.");
            return;
        }
        String gender = genderGroupPremium.getSelection().getActionCommand();

        String birthYear = (String) yearComboboxPremium.getSelectedItem();
        String birthMonth = (String) monthComboboxPremium.getSelectedItem();
        String birthDay = (String) dayComboboxPremium.getSelectedItem();
        String dobValue = birthYear + "/" + birthMonth + "/" + birthDay;

        String startYear = (String) startYearBox.getSelectedItem();
        String startMonth = (String) startMonthBox.getSelectedItem();
        String startDay = (String) startDayBox.getSelectedItem();
        String startDateValue = startYear + "/" + startMonth + "/" + startDay;

        int id;
        try {
            id = Integer.parseInt(idStore);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(frame, "Enter a valid/unique ID.");
            return;
        }

        for (GymMember member : memberList) {
            if (member.getId() == id) {
                JOptionPane.showMessageDialog(frame, "Enter a unique ID.");
                return;
            }
        }

        try {
            int ph = Integer.parseInt(phone);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(frame, "Enter a valid phone number.");
            return;
        }

        if (name.isEmpty() || phone.isEmpty() || email.isEmpty() || location.isEmpty() || trainerName.isEmpty()) {
            JOptionPane.showMessageDialog(frame, "Please fill out all the given fields.");
            return;
        }

        PremiumMember newPremium = new PremiumMember(id, name, location, phone, email, gender, dobValue, startDateValue, trainerName);
        JOptionPane.showMessageDialog(frame, "Premium Member has been successfully added.");
        memberList.add(newPremium);
    });

    clearPremiumButton.addActionListener(e -> {
        idTextPremium.setText("");
        nameTextPremium.setText("");
        phoneTextPremium.setText("");
        locationTextPremium.setText("");
        emailTextPremium.setText("xyz123@gmail.com");
        trainerText.setText("");
        genderGroupPremium.clearSelection();
        yearComboboxPremium.setSelectedIndex(0);
        monthComboboxPremium.setSelectedIndex(0);
        dayComboboxPremium.setSelectedIndex(0);
        startYearBox.setSelectedIndex(0);
        startMonthBox.setSelectedIndex(0);
        startDayBox.setSelectedIndex(0);
    });
}

private void initManageRegularPanel() {
    manageRegularPanel = new JPanel();
    manageRegularPanel.setLayout(null);
    manageRegularPanel.setBounds(0, 70, 1000, 630);

    titleLabelRegular = new JLabel("Manage Regular Member");
    titleLabelRegular.setBounds(350, 20, 300, 30);
    titleLabelRegular.setFont(titleLabelRegular.getFont().deriveFont(18.0f));
    manageRegularPanel.add(titleLabelRegular);

    idLabelManageRegular = new JLabel("Member ID:");
    idLabelManageRegular.setBounds(50, 100, 100, 25);
    idTextManageRegular = new JTextField();
    idTextManageRegular.setBounds(130, 100, 120, 25);
    manageRegularPanel.add(idLabelManageRegular);
    manageRegularPanel.add(idTextManageRegular);

    markAttendanceButton = new JButton("Mark Attendance");
    markAttendanceButton.setBounds(50, 150, 150, 30);
    manageRegularPanel.add(markAttendanceButton);

    activateMembershipButton = new JButton("Activate Membership");
    activateMembershipButton.setBounds(210, 150, 170, 30);
    manageRegularPanel.add(activateMembershipButton);

    deactivateMembershipButton = new JButton("Deactivate Membership");
    deactivateMembershipButton.setBounds(390, 150, 180, 30);
    manageRegularPanel.add(deactivateMembershipButton);

    titleLabelGymUpgrade = new JLabel("Upgrade Gym Plan");
    titleLabelGymUpgrade.setBounds(50, 220, 200, 25);
    titleLabelGymUpgrade.setFont(titleLabelGymUpgrade.getFont().deriveFont(16.0f));
    manageRegularPanel.add(titleLabelGymUpgrade);

    gymPlanLabel = new JLabel("Choose Gym Plan:");
    gymPlanLabel.setBounds(50, 260, 130, 25);
    String[] gymPlans = {"Basic Plan", "Advanced Plan", "Premium Plan"};
    gymPlanCombobox = new JComboBox<>(gymPlans);
    gymPlanCombobox.setBounds(180, 260, 150, 25);
    manageRegularPanel.add(gymPlanLabel);
    manageRegularPanel.add(gymPlanCombobox);

    upgradePlanButton = new JButton("Upgrade");
    upgradePlanButton.setBounds(340, 260, 100, 25);
    manageRegularPanel.add(upgradePlanButton);

    titleLabelRevertMembership = new JLabel("Revert Membership");
    titleLabelRevertMembership.setBounds(50, 310, 200, 25);
    titleLabelRevertMembership.setFont(titleLabelRevertMembership.getFont().deriveFont(16.0f));
    manageRegularPanel.add(titleLabelRevertMembership);

    removalReasonLabel = new JLabel("Reason for Removal:");
    removalReasonLabel.setBounds(50, 350, 150, 25);
    removalReasonText = new JTextField();
    removalReasonText.setBounds(190, 350, 300, 25);
    manageRegularPanel.add(removalReasonLabel);
    manageRegularPanel.add(removalReasonText);

    revertButton = new JButton("Revert");
    revertButton.setBounds(500, 350, 100, 25);
    manageRegularPanel.add(revertButton);

    readFromFileButtonManageRegular = new JButton("Read from File");
    readFromFileButtonManageRegular.setBounds(50, 500, 150, 30);
    manageRegularPanel.add(readFromFileButtonManageRegular);

    saveButtonManageRegular = new JButton("Save to File");
    saveButtonManageRegular.setBounds(210, 500, 150, 30);
    manageRegularPanel.add(saveButtonManageRegular);

    displayButtonManageRegular = new JButton("Display");
    displayButtonManageRegular.setBounds(370, 500, 150, 30);
    manageRegularPanel.add(displayButtonManageRegular);

    clearButtonManageRegular = new JButton("Clear");
    clearButtonManageRegular.setBounds(530, 500, 150, 30);
    manageRegularPanel.add(clearButtonManageRegular);

    // Action listeners for buttons can be added here as you wish
}

private void initManagePremiumPanel() {
    managePremiumPanel = new JPanel();
    managePremiumPanel.setLayout(null);
    managePremiumPanel.setBounds(0, 70, 1000, 630);

    JLabel label = new JLabel("Manage Premium Member - (Add your components here)");
    label.setBounds(50, 50, 400, 30);
    managePremiumPanel.add(label);
}

public static void main(String[] args) {
    SwingUtilities.invokeLater(() -> new GymGUI());
}
