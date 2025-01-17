package ai.bianjie.ddc.service;

import ai.bianjie.ddc.DDCSdkClient;
import ai.bianjie.ddc.SignEventTest;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;

class ChargeServiceTest {

    DDCSdkClient client = new DDCSdkClient.Builder()
            .setAuthorityLogicAddress("0xa7FC5B0F4A0085c5Ce689b919a866675Ce37B66b")
            .setChargeLogicAddress("0x3BBb01B38958d4dbF1e004611EbB3c65979B0511")
            .setDDC721Address("0x3B09b7A00271C5d9AE84593850dE3A526b8BF96e")
            .setDDC1155Address("0xe5d3b9E7D16E03A4A1060c72b5D1cb7806DD9070")
            .setGasLimit("300000")
            .setGasPrice("1")
            .setSignEventListener(new SignEventTest())
            .init();

    ChargeService chargeService = client.getChargeService();
    String sender = "0x953488F7E292A7D6CB0BFF81BA806B82E5FD47A2";

    @Test
    void recharge() throws Exception {
        client.setGatewayUrl("https://opbtest.bsngate.com:18602/api/0e346e1fb134477cafb6c6c2583ce3c4/evmrpc");
        client.setGatewayApiKey("903f4f9268ab4e2eac717c7200429776");
        client.setGatewayApiValue("0c1dd14a41b14cfa83048d839a0593ff");
        String hash = chargeService.recharge(sender, "918F7F275A6C2D158E5B76F769D3F1678958A334", new BigInteger("100000"));
        System.out.print(hash);
    }

    @Test
    void balanceOf() throws Exception {
        client.setGatewayUrl("https://opbtest.bsngate.com:18602/api/0e346e1fb134477cafb6c6c2583ce3c4/evmrpc");
        client.setGatewayApiKey("903f4f9268ab4e2eac717c7200429776");
        client.setGatewayApiValue("0c1dd14a41b14cfa83048d839a0593ff");
        BigInteger balance = chargeService.balanceOf("918F7F275A6C2D158E5B76F769D3F1678958A334");
        System.out.print(balance);
    }

    @Test
    void queryFee() throws Exception {
        client.setGatewayUrl("https://opbtest.bsngate.com:18602/api/0e346e1fb134477cafb6c6c2583ce3c4/evmrpc");
        client.setGatewayApiKey("903f4f9268ab4e2eac717c7200429776");
        client.setGatewayApiValue("0c1dd14a41b14cfa83048d839a0593ff");
        BigInteger fee = chargeService.queryFee("0x503f45958F57Da55170B54796F4eD224c9fef9d7", "0xe985e9c5");
        System.out.print(fee);
    }

    @Test
    void selfRecharge() throws Exception {
        client.setGatewayUrl("https://opbtest.bsngate.com:18602/api/0e346e1fb134477cafb6c6c2583ce3c4/evmrpc");
        client.setGatewayApiKey("903f4f9268ab4e2eac717c7200429776");
        client.setGatewayApiValue("0c1dd14a41b14cfa83048d839a0593ff");
        String hash = chargeService.selfRecharge(sender, new BigInteger("1000"));
        System.out.print(hash);
    }

    @Test
    void setFee() throws Exception {
        client.setGatewayUrl("https://opbtest.bsngate.com:18602/api/0e346e1fb134477cafb6c6c2583ce3c4/evmrpc");
        client.setGatewayApiKey("903f4f9268ab4e2eac717c7200429776");
        client.setGatewayApiValue("0c1dd14a41b14cfa83048d839a0593ff");
        String hash = chargeService.setFee(sender, "0x503f45958F57Da55170B54796F4eD224c9fef9d7", "0xe985e9c5", new BigInteger("1000"));
        System.out.print(hash);
    }

    @Test
    void delFee() throws Exception {
        client.setGatewayUrl("https://opbtest.bsngate.com:18602/api/0e346e1fb134477cafb6c6c2583ce3c4/evmrpc");
        client.setGatewayApiKey("903f4f9268ab4e2eac717c7200429776");
        client.setGatewayApiValue("0c1dd14a41b14cfa83048d839a0593ff");
        String hash = chargeService.delFee(sender, "0x503f45958F57Da55170B54796F4eD224c9fef9d7", "0xe985e9c5");
        System.out.print(hash);
    }

    @Test
    void delDDC() throws Exception {
        client.setGatewayUrl("https://opbtest.bsngate.com:18602/api/0e346e1fb134477cafb6c6c2583ce3c4/evmrpc");
        client.setGatewayApiKey("903f4f9268ab4e2eac717c7200429776");
        client.setGatewayApiValue("0c1dd14a41b14cfa83048d839a0593ff");
        String hash = chargeService.delDDC(sender, "0x503f45958F57Da55170B54796F4eD224c9fef9d7");
        System.out.print(hash);
    }

}