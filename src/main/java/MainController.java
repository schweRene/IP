package com.example.ip;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;


import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Collections;

public class MainController {
    @FXML
    private ImageView netImage;
    @FXML
    private Button closeBtn;

    @FXML
    private Button hostBtn;

    @FXML
    private Label hostLabel;

    @FXML
    private Button ipBtn;

    @FXML
    private Label ipLabel;

    @FXML
    private Button macBtn;

    @FXML
    private Label macLabel;


    @FXML
    void close(ActionEvent event) {
        System.exit(0);
    }


    public void adress(ActionEvent event) {
        String ipAdresse = getIPAddress();
        ipLabel.setText(ipAdresse);
    }


    private String getIPAddress() {
        try {
            InetAddress ip = InetAddress.getLocalHost();
            return ip.getHostAddress();
        } catch (UnknownHostException e) {
            return "IP-Adresse konnte nicht ausgelesen werden.";
        }
    }
    public void mac(ActionEvent event){

        String macAddress = getMacAddress();
        macLabel.setText(macAddress);
    }

    private String getMacAddress() {
        try {
            // get all network interfaces
            for (NetworkInterface networkInterface : Collections.list(NetworkInterface.getNetworkInterfaces())) {
                // get hardware address (MAC address) of the network interface
                byte[] macAddressBytes = networkInterface.getHardwareAddress();
                if (macAddressBytes != null) {
                    // convert MAC address bytes to string
                    StringBuilder macAddressBuilder = new StringBuilder();
                    for (byte b : macAddressBytes) {
                        macAddressBuilder.append(String.format("%02X:", b));
                    }
                    if (macAddressBuilder.length() > 0) {
                        macAddressBuilder.deleteCharAt(macAddressBuilder.length() - 1);
                    }
                    return macAddressBuilder.toString();
                }
            }
        } catch (SocketException e) {
            e.printStackTrace();
        }
        return "MAC-Adresse konnte nicht ausgelesen werden.";
    }

    public void hostName(){
        String hostname = getHostname();
        hostLabel.setText(hostname);
    }

    private String getHostname() {
        try {
            InetAddress localMachine = InetAddress.getLocalHost();
            return localMachine.getHostName();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        return "Hostname konnte nicht ausgelesen werden.";
    }


}
