package com.psiarb.go.psi_arb;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.lang.reflect.Field;
import java.math.BigDecimal;

import static android.widget.Toast.LENGTH_LONG;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "TAG";
    TextView text;
    Button btn;
    private double bid1 = 0;
    private double ask1 = 0;
    private double x = 0;
    public int path = 0;
    StringBuffer optimalPathText = new StringBuffer();

    static double profitTarget = .9;

    public static BigDecimal cd1b = new BigDecimal(0);
    public static BigDecimal cd1a = new BigDecimal(0);
    public static BigDecimal cd2b = new BigDecimal(0);
    public static BigDecimal cd2a = new BigDecimal(0);
    public static BigDecimal cd3b = new BigDecimal(0);
    public static BigDecimal cd3a = new BigDecimal(0);
    double triArbitrage[] = new double[10000000];


    // Kraken      33


    ExchangeRateStorage EOSETH_kraken = new ExchangeRateStorage();
    ExchangeRateStorage BCHBTC_kraken = new ExchangeRateStorage();
    ExchangeRateStorage ETHEOS_kraken = new ExchangeRateStorage();
    ExchangeRateStorage LTCBTC_kraken = new ExchangeRateStorage();
    ExchangeRateStorage ETCBTC_kraken = new ExchangeRateStorage();
    ExchangeRateStorage ICNBTC_kraken = new ExchangeRateStorage();
    ExchangeRateStorage REPBTC_kraken = new ExchangeRateStorage();
    ExchangeRateStorage GNOETH_kraken = new ExchangeRateStorage();
    ExchangeRateStorage ZECBTC_kraken = new ExchangeRateStorage();
    ExchangeRateStorage ETCETH_kraken = new ExchangeRateStorage();
    ExchangeRateStorage ICNETH_kraken = new ExchangeRateStorage();
    ExchangeRateStorage GNOBTC_kraken = new ExchangeRateStorage();
    ExchangeRateStorage MLNBTC_kraken = new ExchangeRateStorage();
    ExchangeRateStorage DSHBTC_kraken = new ExchangeRateStorage();
    ExchangeRateStorage XLMBTC_kraken = new ExchangeRateStorage();
    ExchangeRateStorage ETHBTC_kraken = new ExchangeRateStorage();
    ExchangeRateStorage XMRBTC_kraken = new ExchangeRateStorage();
    ExchangeRateStorage XRPBTC_kraken = new ExchangeRateStorage();


    //GDAX Pairs     9

    ExchangeRateStorage LTCBTC_gdax = new ExchangeRateStorage();
    ExchangeRateStorage ETHBTC_gdax = new ExchangeRateStorage();


    //Gemini    3

    ExchangeRateStorage ETHBTC_gemini = new ExchangeRateStorage();

    //Binance

    ExchangeRateStorage ETHBTC_binance = new ExchangeRateStorage();
    ExchangeRateStorage XMRETH_binance = new ExchangeRateStorage();
    ;
    ExchangeRateStorage XMRBTC_binance = new ExchangeRateStorage();
    ;
    ExchangeRateStorage XRPBTC_binance = new ExchangeRateStorage();
    ;
    ExchangeRateStorage XRPETH_binance = new ExchangeRateStorage();
    ;


    //Poloniex

    ExchangeRateStorage LTCBTC_poloniex = new ExchangeRateStorage();
    ExchangeRateStorage BTSBTC_poloniex = new ExchangeRateStorage();
    ExchangeRateStorage XEMBTC_poloniex = new ExchangeRateStorage();
    ExchangeRateStorage ETCBTC_poloniex = new ExchangeRateStorage();
    ExchangeRateStorage BCHBTC_poloniex = new ExchangeRateStorage();
    ExchangeRateStorage DSHBTC_poloniex = new ExchangeRateStorage();   // DASH
    //    ExchangeRateStorage DOGBTC_poloniex = new ExchangeRateStorage();  // DOGE
    ExchangeRateStorage SCXBTC_poloniex = new ExchangeRateStorage();      // SIACOIN
    ExchangeRateStorage ZRXBTC_poloniex = new ExchangeRateStorage();
    ExchangeRateStorage LSKBTC_poloniex = new ExchangeRateStorage();
    ExchangeRateStorage STTBTC_poloniex = new ExchangeRateStorage();    // STRATIS
    //  ExchangeRateStorage DGBBTC_poloniex = new ExchangeRateStorage();
    ExchangeRateStorage OMGBTC_poloniex = new ExchangeRateStorage();
    ExchangeRateStorage STMBTC_poloniex = new ExchangeRateStorage();   // STEEM
    ExchangeRateStorage REPBTC_poloniex = new ExchangeRateStorage();
    //  ExchangeRateStorage FTCBTC_poloniex = new ExchangeRateStorage();     // FACTOM
    ExchangeRateStorage RICBTC_poloniex = new ExchangeRateStorage();
    ExchangeRateStorage GMEBTC_poloniex = new ExchangeRateStorage();     // GAME
    ExchangeRateStorage NMEBTC_poloniex = new ExchangeRateStorage();
    ExchangeRateStorage MADBTC_poloniex = new ExchangeRateStorage();     // MAID
    // ExchangeRateStorage BCNBTC_poloniex = new ExchangeRateStorage();
    ExchangeRateStorage ARRBTC_poloniex = new ExchangeRateStorage();    // ARDOR
    ExchangeRateStorage PASBTC_poloniex = new ExchangeRateStorage();    // PASCAL COIN
    ExchangeRateStorage GNTBTC_poloniex = new ExchangeRateStorage();    // GOLEM
    ExchangeRateStorage EXPBTC_poloniex = new ExchangeRateStorage();   //EXPANSE
    ExchangeRateStorage GASBTC_poloniex = new ExchangeRateStorage();
    ExchangeRateStorage DCRBTC_poloniex = new ExchangeRateStorage();
    ExchangeRateStorage VTCBTC_poloniex = new ExchangeRateStorage();
    ExchangeRateStorage EMCBTC_poloniex = new ExchangeRateStorage();    // EMC2  EINSTEINIUM
    ExchangeRateStorage SYSBTC_poloniex = new ExchangeRateStorage();
    ExchangeRateStorage GNOBTC_poloniex = new ExchangeRateStorage();
    ExchangeRateStorage VRCBTC_poloniex = new ExchangeRateStorage();    // VERICOIN
    ExchangeRateStorage XCPBTC_poloniex = new ExchangeRateStorage();   // COUNTERPARTY
    ExchangeRateStorage PPCBTC_poloniex = new ExchangeRateStorage();   // PEERCOIN
    ExchangeRateStorage BRSBTC_poloniex = new ExchangeRateStorage();   // BURST
    ExchangeRateStorage CVCBTC_poloniex = new ExchangeRateStorage();   /// CIVIC
    ExchangeRateStorage LBCBTC_poloniex = new ExchangeRateStorage();   /// LIBRARY CRED
    ExchangeRateStorage CLMBTC_poloniex = new ExchangeRateStorage();   // CLAM
    ExchangeRateStorage XPMBTC_poloniex = new ExchangeRateStorage();   // PRIME COIN
    ExchangeRateStorage OMNBTC_poloniex = new ExchangeRateStorage();   // OMNI
    ExchangeRateStorage POTBTC_poloniex = new ExchangeRateStorage();    // POT
    ExchangeRateStorage FLDBTC_poloniex = new ExchangeRateStorage();    // FOLDING
    ExchangeRateStorage BLKBTC_poloniex = new ExchangeRateStorage();   // BLACK
    ExchangeRateStorage AMPBTC_poloniex = new ExchangeRateStorage();   // SYNERIO AMP
    ExchangeRateStorage FLOBTC_poloniex = new ExchangeRateStorage();   // FLORIN
    ExchangeRateStorage PNKBTC_poloniex = new ExchangeRateStorage();   //PINK COIN
    ExchangeRateStorage NAVBTC_poloniex = new ExchangeRateStorage();    // NAV COIN
    ExchangeRateStorage VIABTC_poloniex = new ExchangeRateStorage();  // VIA
    ExchangeRateStorage NMCBTC_poloniex = new ExchangeRateStorage();   // NAME COIN
    ExchangeRateStorage NXCBTC_poloniex = new ExchangeRateStorage();   // NEXIUM
    ExchangeRateStorage GRCBTC_poloniex = new ExchangeRateStorage();   // GRIDCOIN
    ExchangeRateStorage BCYBTC_poloniex = new ExchangeRateStorage();    // BIT CRYSTALS
    ExchangeRateStorage XBCBTC_poloniex = new ExchangeRateStorage();   // BITCOIN+
    ExchangeRateStorage RDSBTC_poloniex = new ExchangeRateStorage();    // RADS
    //   ExchangeRateStorage SBDBTC_poloniex = new ExchangeRateStorage();   // STEEM DOLLARS
    ExchangeRateStorage NESBTC_poloniex = new ExchangeRateStorage();   // NEOS COIN
    ExchangeRateStorage BTDBTC_poloniex = new ExchangeRateStorage();   // BITCOIN DARK
    ExchangeRateStorage VCHBTC_poloniex = new ExchangeRateStorage();  // VCASH
    ExchangeRateStorage HUCBTC_poloniex = new ExchangeRateStorage();  // HUNTERCOIN
    ExchangeRateStorage BTMBTC_poloniex = new ExchangeRateStorage();  // BITMARK
    ExchangeRateStorage ZECBTC_poloniex = new ExchangeRateStorage();
    ExchangeRateStorage ETCETH_poloniex = new ExchangeRateStorage();
    ExchangeRateStorage BCHETH_poloniex = new ExchangeRateStorage();
    ExchangeRateStorage ZRXETH_poloniex = new ExchangeRateStorage();
    ExchangeRateStorage ZECETH_poloniex = new ExchangeRateStorage();
    ExchangeRateStorage GASETH_poloniex = new ExchangeRateStorage();
    ExchangeRateStorage OMGETH_poloniex = new ExchangeRateStorage();
    ExchangeRateStorage REPETH_poloniex = new ExchangeRateStorage();
    ExchangeRateStorage LSKETH_poloniex = new ExchangeRateStorage();
    ExchangeRateStorage GNOETH_poloniex = new ExchangeRateStorage();
    ExchangeRateStorage GNTETH_poloniex = new ExchangeRateStorage();
    ExchangeRateStorage CVCETH_poloniex = new ExchangeRateStorage();
    ExchangeRateStorage STMETH_poloniex = new ExchangeRateStorage();   // STEEM
    ExchangeRateStorage LTCXMR_poloniex = new ExchangeRateStorage();
    ExchangeRateStorage DSHXMR_poloniex = new ExchangeRateStorage();   // DASH
    ExchangeRateStorage ZECXMR_poloniex = new ExchangeRateStorage();
    ExchangeRateStorage NXTXMR_poloniex = new ExchangeRateStorage();
    ExchangeRateStorage STJBTC_poloniex = new ExchangeRateStorage();    // STORJBTC
    ExchangeRateStorage XLMBTC_poloniex = new ExchangeRateStorage();    // STRBTC (STELLAR)


    ExchangeRateStorage ETHBTC_poloniex = new ExchangeRateStorage();
    ExchangeRateStorage XMRBTC_poloniex = new ExchangeRateStorage();
    ExchangeRateStorage XRPBTC_poloniex = new ExchangeRateStorage();

    //HITBIT

    //Bittrex


    // ================================================  TOTAL PAIRS   45


    static String c1;
    static String c2;
    static String c3;
    static int z = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text = (TextView) findViewById(R.id.bidask);
        btn = (Button) findViewById(R.id.button);
        text.setMovementMethod(new ScrollingMovementMethod());

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Toast.makeText(getApplicationContext(), "Please wait a minute while market data loads", LENGTH_LONG).show();

                new fetchData().execute();

            }
        });


    }

    public class fetchData extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... strings) {

            StringBuffer buffer = new StringBuffer();

            try {


                Document doc = Jsoup.connect("https://www.investing.com/currencies/eth-btc").get();
                Elements span = doc.select("span");
                String method = span.select("span").text();
                buffer.append(method);
                String haystack = buffer.toString();
                calculateBIDASK ETHBTCpoloniex = new calculateBIDASK();

                ETHBTC_poloniex.setBid(ETHBTCpoloniex.getBid(bid1, haystack));
                ETHBTC_poloniex.setAsk(ETHBTCpoloniex.getAsk(ask1, haystack));


                System.out.println("OK ETHBTC_poloniex is" + ETHBTC_poloniex.getBid() + " " + ETHBTC_poloniex.getAsk());



          /*      doc = Jsoup.connect("https://www.investing.com/currencies/eth-btc?cid=1054867").get();
                span = doc.select("span");
                buffer.delete(0,buffer.length());
                method = span.select("span").text();
                buffer.append(method);
                haystack = buffer.toString();
                calculateBIDASK ETHBTCcexio = new calculateBIDASK();

        //        ETHBTC_cexio.setBid(ETHBTCcexio.getBid(bid1,haystack));
         //       ETHBTC_cexio.setAsk(ETHBTCcexio.getAsk(ask1,haystack));
        //        ETHBTC_cexio.setcPair("ETHBTC_Cexio");

         //       System.out.println("OK ETHBTC_cexio is" + ETHBTC_cexio.getBid() + " " + ETHBTC_cexio.getAsk());



        */
                doc = Jsoup.connect("https://www.investing.com/currencies/eth-btc?cid=1031692").get();
                span = doc.select("span");
                buffer.delete(0, buffer.length());
                method = span.select("span").text();
                buffer.append(method);
                haystack = buffer.toString();
                calculateBIDASK ETHBTCbinance = new calculateBIDASK();

                ETHBTC_binance.setBid(ETHBTCbinance.getBid(bid1, haystack));
                ETHBTC_binance.setAsk(ETHBTCbinance.getAsk(ask1, haystack));
                ETHBTC_binance.setcPair("ETHBTC_Binance");

                System.out.println("OK ETHBTC_binance is" + ETHBTC_binance.getBid() + " " + ETHBTC_binance.getAsk());

                doc = Jsoup.connect("https://www.investing.com/currencies/eth-btc?cid=1010786").get();
                span = doc.select("span");
                buffer.delete(0, buffer.length());
                method = span.select("span").text();
                buffer.append(method);
                haystack = buffer.toString();
                calculateBIDASK ETHBTCkraken = new calculateBIDASK();

                ETHBTC_kraken.setBid(ETHBTCkraken.getBid(bid1, haystack));
                ETHBTC_kraken.setAsk(ETHBTCkraken.getAsk(ask1, haystack));


                System.out.println("OK ETHBTC_kraken is" + ETHBTC_kraken.getBid() + " " + ETHBTC_kraken.getAsk());

                doc = Jsoup.connect("https://www.investing.com/currencies/eth-btc?cid=1010799").get();
                span = doc.select("span");
                buffer.delete(0, buffer.length());
                method = span.select("span").text();
                buffer.append(method);
                haystack = buffer.toString();
                calculateBIDASK ETHBTCgdax = new calculateBIDASK();

                ETHBTC_gdax.setBid(ETHBTCgdax.getBid(bid1, haystack));
                ETHBTC_gdax.setAsk(ETHBTCgdax.getAsk(ask1, haystack));

                System.out.println("OK ETHBTC_gdax is" + ETHBTC_gdax.getBid() + " " + ETHBTC_gdax.getAsk());


                //========================poloniex altcoin


                doc = Jsoup.connect("https://www.investing.com/currencies/rep-btc?cid=1036951").get();
                span = doc.select("span");
                buffer.delete(0, buffer.length());
                method = span.select("span").text();
                buffer.append(method);
                haystack = buffer.toString();
                calculateBIDASK REPBTCpoloniex = new calculateBIDASK();

                REPBTC_poloniex.setBid(REPBTCpoloniex.getBid(bid1, haystack));
                REPBTC_poloniex.setAsk(REPBTCpoloniex.getAsk(ask1, haystack));

                System.out.println("OK REPBTC_poloniex is" + REPBTC_poloniex.getBid() + " " + REPBTC_poloniex.getAsk());


                // Poloniex ALTCOIN

                doc = Jsoup.connect("https://www.investing.com/currencies/ltc-btc").get();
                span = doc.select("span");
                buffer.delete(0, buffer.length());
                method = span.select("span").text();
                buffer.append(method);
                haystack = buffer.toString();
                calculateBIDASK LTCBTCpoloniex = new calculateBIDASK();

                LTCBTC_poloniex.setBid(LTCBTCpoloniex.getBid(bid1, haystack));
                LTCBTC_poloniex.setAsk(LTCBTCpoloniex.getAsk(ask1, haystack));

                System.out.println("OK LTCBTC_poloniex is" + LTCBTC_poloniex.getBid() + " " + LTCBTC_poloniex.getAsk());

                doc = Jsoup.connect("https://www.investing.com/currencies/bts-btc").get();
                span = doc.select("span");
                buffer.delete(0, buffer.length());
                method = span.select("span").text();
                buffer.append(method);
                haystack = buffer.toString();
                calculateBIDASK BTSBTCpoloniex = new calculateBIDASK();

                BTSBTC_poloniex.setBid(BTSBTCpoloniex.getBid(bid1, haystack));
                BTSBTC_poloniex.setAsk(BTSBTCpoloniex.getAsk(ask1, haystack));

                System.out.println("OK BTSBTC_poloniex is" + BTSBTC_poloniex.getBid() + " " + BTSBTC_poloniex.getAsk());

                doc = Jsoup.connect("https://www.investing.com/currencies/xem-btc").get();
                span = doc.select("span");
                buffer.delete(0, buffer.length());
                method = span.select("span").text();
                buffer.append(method);
                haystack = buffer.toString();
                calculateBIDASK XEMBTCpoloniex = new calculateBIDASK();

                XEMBTC_poloniex.setBid(XEMBTCpoloniex.getBid(bid1, haystack));
                XEMBTC_poloniex.setAsk(XEMBTCpoloniex.getAsk(ask1, haystack));

                System.out.println("OK XEMBTC_poloniex is" + XEMBTC_poloniex.getBid() + " " + XEMBTC_poloniex.getAsk());

                doc = Jsoup.connect("https://www.investing.com/currencies/dash-btc").get();
                span = doc.select("span");
                buffer.delete(0, buffer.length());
                method = span.select("span").text();
                buffer.append(method);
                haystack = buffer.toString();
                calculateBIDASK DSHBTCpoloniex = new calculateBIDASK();

                DSHBTC_poloniex.setBid(DSHBTCpoloniex.getBid(bid1, haystack));
                DSHBTC_poloniex.setAsk(DSHBTCpoloniex.getAsk(ask1, haystack));

                System.out.println("OK DSHBTC_poloniex is" + DSHBTC_poloniex.getBid() + " " + DSHBTC_poloniex.getAsk());

                doc = Jsoup.connect("https://www.investing.com/currencies/bch-btc?cid=1035803").get();
                span = doc.select("span");
                buffer.delete(0, buffer.length());
                method = span.select("span").text();
                buffer.append(method);
                haystack = buffer.toString();
                calculateBIDASK BCHBTCpoloniex = new calculateBIDASK();

                BCHBTC_poloniex.setBid(BCHBTCpoloniex.getBid(bid1, haystack));
                BCHBTC_poloniex.setAsk(BCHBTCpoloniex.getAsk(ask1, haystack));

                System.out.println("OK BCHBTC_poloniex is" + BCHBTC_poloniex.getBid() + " " + BCHBTC_poloniex.getAsk());

                doc = Jsoup.connect("https://www.investing.com/currencies/etc-btc").get();
                span = doc.select("span");
                buffer.delete(0, buffer.length());
                method = span.select("span").text();
                buffer.append(method);
                haystack = buffer.toString();
                calculateBIDASK ETCBTCpoloniex = new calculateBIDASK();

                ETCBTC_poloniex.setBid(ETCBTCpoloniex.getBid(bid1, haystack));
                ETCBTC_poloniex.setAsk(ETCBTCpoloniex.getAsk(ask1, haystack));

                System.out.println("OK ETCBTC_poloniex is" + ETCBTC_poloniex.getBid() + " " + ETCBTC_poloniex.getAsk());


                doc = Jsoup.connect("https://www.investing.com/currencies/sc-btc").get();
                span = doc.select("span");
                buffer.delete(0, buffer.length());
                method = span.select("span").text();
                buffer.append(method);
                haystack = buffer.toString();
                calculateBIDASK SCXBTCpoloniex = new calculateBIDASK();

                SCXBTC_poloniex.setBid(SCXBTCpoloniex.getBid(bid1, haystack));
                SCXBTC_poloniex.setAsk(SCXBTCpoloniex.getAsk(ask1, haystack));

                System.out.println("OK SCXBTC_poloniex is" + SCXBTC_poloniex.getBid() + " " + SCXBTC_poloniex.getAsk());

                doc = Jsoup.connect("https://www.investing.com/currencies/zrx-btc").get();
                span = doc.select("span");
                buffer.delete(0, buffer.length());
                method = span.select("span").text();
                buffer.append(method);
                haystack = buffer.toString();
                calculateBIDASK ZRXBTCpoloniex = new calculateBIDASK();

                ZRXBTC_poloniex.setBid(ZRXBTCpoloniex.getBid(bid1, haystack));
                ZRXBTC_poloniex.setAsk(ZRXBTCpoloniex.getAsk(ask1, haystack));

                System.out.println("OK ZRXBTC_poloniex is" + ZRXBTC_poloniex.getBid() + " " + ZRXBTC_poloniex.getAsk());

                doc = Jsoup.connect("https://www.investing.com/currencies/lsk-btc?cid=1035802").get();
                span = doc.select("span");
                buffer.delete(0, buffer.length());
                method = span.select("span").text();
                buffer.append(method);
                haystack = buffer.toString();
                calculateBIDASK LSKBTCpoloniex = new calculateBIDASK();

                LSKBTC_poloniex.setBid(LSKBTCpoloniex.getBid(bid1, haystack));
                LSKBTC_poloniex.setAsk(LSKBTCpoloniex.getAsk(ask1, haystack));

                System.out.println("OK LSKBTC_poloniex is" + LSKBTC_poloniex.getBid() + " " + LSKBTC_poloniex.getAsk());

                doc = Jsoup.connect("https://www.investing.com/currencies/strat-btc?cid=1031077").get();
                span = doc.select("span");
                buffer.delete(0, buffer.length());
                method = span.select("span").text();
                buffer.append(method);
                haystack = buffer.toString();
                calculateBIDASK STTBTCpoloniex = new calculateBIDASK();

                STTBTC_poloniex.setBid(STTBTCpoloniex.getBid(bid1, haystack));
                STTBTC_poloniex.setAsk(STTBTCpoloniex.getAsk(ask1, haystack));

                System.out.println("OK STTBTC_poloniex is" + STTBTC_poloniex.getBid() + " " + STTBTC_poloniex.getAsk());


                doc = Jsoup.connect("https://www.investing.com/currencies/omg-btc?cid=1054898").get();
                span = doc.select("span");
                buffer.delete(0, buffer.length());
                method = span.select("span").text();
                buffer.append(method);
                haystack = buffer.toString();
                calculateBIDASK OMGBTCpoloniex = new calculateBIDASK();

                OMGBTC_poloniex.setBid(OMGBTCpoloniex.getBid(bid1, haystack));
                OMGBTC_poloniex.setAsk(OMGBTCpoloniex.getAsk(ask1, haystack));

                System.out.println("OK OMGBTC_poloniex is" + OMGBTC_poloniex.getBid() + " " + OMGBTC_poloniex.getAsk());

                doc = Jsoup.connect("https://www.investing.com/currencies/steem-btc?cid=1031078").get();
                span = doc.select("span");
                buffer.delete(0, buffer.length());
                method = span.select("span").text();
                buffer.append(method);
                haystack = buffer.toString();
                calculateBIDASK STMBTCpoloniex = new calculateBIDASK();

                STMBTC_poloniex.setBid(STMBTCpoloniex.getBid(bid1, haystack));
                STMBTC_poloniex.setAsk(STMBTCpoloniex.getAsk(ask1, haystack));

                System.out.println("OK STMBTC_poloniex is" + STMBTC_poloniex.getBid() + " " + STMBTC_poloniex.getAsk());

                doc = Jsoup.connect("https://www.investing.com/currencies/ric-btc").get();
                span = doc.select("span");
                buffer.delete(0, buffer.length());
                method = span.select("span").text();
                buffer.append(method);
                haystack = buffer.toString();
                calculateBIDASK RICBTCpoloniex = new calculateBIDASK();

                RICBTC_poloniex.setBid(RICBTCpoloniex.getBid(bid1, haystack));
                RICBTC_poloniex.setAsk(RICBTCpoloniex.getAsk(ask1, haystack));

                System.out.println("OK RICBTC_poloniex is" + RICBTC_poloniex.getBid() + " " + RICBTC_poloniex.getAsk());

                doc = Jsoup.connect("https://www.investing.com/currencies/game-btc?cid=1036950").get();
                span = doc.select("span");
                buffer.delete(0, buffer.length());
                method = span.select("span").text();
                buffer.append(method);
                haystack = buffer.toString();
                calculateBIDASK GMEBTCpoloniex = new calculateBIDASK();

                GMEBTC_poloniex.setBid(GMEBTCpoloniex.getBid(bid1, haystack));
                GMEBTC_poloniex.setAsk(GMEBTCpoloniex.getAsk(ask1, haystack));

                System.out.println("OK GMEBTC_poloniex is" + GMEBTC_poloniex.getBid() + " " + GMEBTC_poloniex.getAsk());

                doc = Jsoup.connect("https://www.investing.com/currencies/nmc-btc").get();
                span = doc.select("span");
                buffer.delete(0, buffer.length());
                method = span.select("span").text();
                buffer.append(method);
                haystack = buffer.toString();
                calculateBIDASK NMEBTCpoloniex = new calculateBIDASK();

                NMEBTC_poloniex.setBid(NMEBTCpoloniex.getBid(bid1, haystack));
                NMEBTC_poloniex.setAsk(NMEBTCpoloniex.getAsk(ask1, haystack));

                System.out.println("OK NMEBTC_poloniex is" + NMEBTC_poloniex.getBid() + " " + NMEBTC_poloniex.getAsk());

                doc = Jsoup.connect("https://www.investing.com/currencies/maid-btc?cid=1036952").get();
                span = doc.select("span");
                buffer.delete(0, buffer.length());
                method = span.select("span").text();
                buffer.append(method);
                haystack = buffer.toString();
                calculateBIDASK MADBTCpoloniex = new calculateBIDASK();

                MADBTC_poloniex.setBid(MADBTCpoloniex.getBid(bid1, haystack));
                MADBTC_poloniex.setAsk(MADBTCpoloniex.getAsk(ask1, haystack));

                System.out.println("OK MADBTC_poloniex is" + MADBTC_poloniex.getBid() + " " + MADBTC_poloniex.getAsk());


                doc = Jsoup.connect("https://www.investing.com/currencies/ardr-btc?cid=1036960").get();
                span = doc.select("span");
                buffer.delete(0, buffer.length());
                method = span.select("span").text();
                buffer.append(method);
                haystack = buffer.toString();
                calculateBIDASK ARRBTCpoloniex = new calculateBIDASK();

                ARRBTC_poloniex.setBid(ARRBTCpoloniex.getBid(bid1, haystack));
                ARRBTC_poloniex.setAsk(ARRBTCpoloniex.getAsk(ask1, haystack));

                System.out.println("OK ARRBTC_poloniex is" + ARRBTC_poloniex.getBid() + " " + ARRBTC_poloniex.getAsk());

                doc = Jsoup.connect("https://www.investing.com/currencies/pasc-btc").get();
                span = doc.select("span");
                buffer.delete(0, buffer.length());
                method = span.select("span").text();
                buffer.append(method);
                haystack = buffer.toString();
                calculateBIDASK PASBTCpoloniex = new calculateBIDASK();

                PASBTC_poloniex.setBid(PASBTCpoloniex.getBid(bid1, haystack));
                PASBTC_poloniex.setAsk(PASBTCpoloniex.getAsk(ask1, haystack));

                System.out.println("OK PASBTC_poloniex is" + PASBTC_poloniex.getBid() + " " + PASBTC_poloniex.getAsk());

                doc = Jsoup.connect("https://www.investing.com/currencies/gnt-btc?cid=1036954").get();
                span = doc.select("span");
                buffer.delete(0, buffer.length());
                method = span.select("span").text();
                buffer.append(method);
                haystack = buffer.toString();
                calculateBIDASK GNTBTCpoloniex = new calculateBIDASK();

                GNTBTC_poloniex.setBid(GNTBTCpoloniex.getBid(bid1, haystack));
                GNTBTC_poloniex.setAsk(GNTBTCpoloniex.getAsk(ask1, haystack));

                System.out.println("OK GNTBTC_poloniex is" + GNTBTC_poloniex.getBid() + " " + GNTBTC_poloniex.getAsk());

                doc = Jsoup.connect("https://www.investing.com/currencies/exp-btc?cid=1056690").get();
                span = doc.select("span");
                buffer.delete(0, buffer.length());
                method = span.select("span").text();
                buffer.append(method);
                haystack = buffer.toString();
                calculateBIDASK EXPBTCpoloniex = new calculateBIDASK();

                EXPBTC_poloniex.setBid(EXPBTCpoloniex.getBid(bid1, haystack));
                EXPBTC_poloniex.setAsk(EXPBTCpoloniex.getAsk(ask1, haystack));

                System.out.println("OK EXPBTC_poloniex is" + EXPBTC_poloniex.getBid() + " " + EXPBTC_poloniex.getAsk());

                doc = Jsoup.connect("https://www.investing.com/currencies/gas-btc?cid=1054926").get();
                span = doc.select("span");
                buffer.delete(0, buffer.length());
                method = span.select("span").text();
                buffer.append(method);
                haystack = buffer.toString();
                calculateBIDASK GASBTCpoloniex = new calculateBIDASK();

                GASBTC_poloniex.setBid(GASBTCpoloniex.getBid(bid1, haystack));
                GASBTC_poloniex.setAsk(GASBTCpoloniex.getAsk(ask1, haystack));

                System.out.println("OK GASBTC_poloniex is" + GASBTC_poloniex.getBid() + " " + GASBTC_poloniex.getAsk());

                doc = Jsoup.connect("https://www.investing.com/currencies/dcr-btc?cid=1036956").get();
                span = doc.select("span");
                buffer.delete(0, buffer.length());
                method = span.select("span").text();
                buffer.append(method);
                haystack = buffer.toString();
                calculateBIDASK DCRBTCpoloniex = new calculateBIDASK();

                DCRBTC_poloniex.setBid(DCRBTCpoloniex.getBid(bid1, haystack));
                DCRBTC_poloniex.setAsk(DCRBTCpoloniex.getAsk(ask1, haystack));

                System.out.println("OK DCRBTC_poloniex is" + DCRBTC_poloniex.getBid() + " " + DCRBTC_poloniex.getAsk());

                doc = Jsoup.connect("https://www.investing.com/currencies/vtc-btc?cid=1050049").get();
                span = doc.select("span");
                buffer.delete(0, buffer.length());
                method = span.select("span").text();
                buffer.append(method);
                haystack = buffer.toString();
                calculateBIDASK VTCBTCpoloniex = new calculateBIDASK();

                VTCBTC_poloniex.setBid(VTCBTCpoloniex.getBid(bid1, haystack));
                VTCBTC_poloniex.setAsk(VTCBTCpoloniex.getAsk(ask1, haystack));

                System.out.println("OK VTCBTC_poloniex is" + VTCBTC_poloniex.getBid() + " " + VTCBTC_poloniex.getAsk());

                doc = Jsoup.connect("https://www.investing.com/currencies/emc2-btc?cid=1056120").get();
                span = doc.select("span");
                buffer.delete(0, buffer.length());
                method = span.select("span").text();
                buffer.append(method);
                haystack = buffer.toString();
                calculateBIDASK EMCBTCpoloniex = new calculateBIDASK();

                EMCBTC_poloniex.setBid(EMCBTCpoloniex.getBid(bid1, haystack));
                EMCBTC_poloniex.setAsk(EMCBTCpoloniex.getAsk(ask1, haystack));

                System.out.println("OK EMCBTC_poloniex is" + EMCBTC_poloniex.getBid() + " " + EMCBTC_poloniex.getAsk());

                doc = Jsoup.connect("https://www.investing.com/currencies/gno-btc?cid=1036957").get();
                span = doc.select("span");
                buffer.delete(0, buffer.length());
                method = span.select("span").text();
                buffer.append(method);
                haystack = buffer.toString();
                calculateBIDASK GNOBTCpoloniex = new calculateBIDASK();

                GNOBTC_poloniex.setBid(GNOBTCpoloniex.getBid(bid1, haystack));
                GNOBTC_poloniex.setAsk(GNOBTCpoloniex.getAsk(ask1, haystack));

                System.out.println("OK GNOBTC_poloniex is" + GNOBTC_poloniex.getBid() + " " + GNOBTC_poloniex.getAsk());

                doc = Jsoup.connect("https://www.investing.com/currencies/vrc-btc?cid=1050050").get();
                span = doc.select("span");
                buffer.delete(0, buffer.length());
                method = span.select("span").text();
                buffer.append(method);
                haystack = buffer.toString();
                calculateBIDASK VRCBTCpoloniex = new calculateBIDASK();

                VRCBTC_poloniex.setBid(VRCBTCpoloniex.getBid(bid1, haystack));
                VRCBTC_poloniex.setAsk(VRCBTCpoloniex.getAsk(ask1, haystack));

                System.out.println("OK VRCBTC_poloniex is" + VRCBTC_poloniex.getBid() + " " + VRCBTC_poloniex.getAsk());


                doc = Jsoup.connect("https://www.investing.com/currencies/xcp-btc?cid=1056688").get();
                span = doc.select("span");
                buffer.delete(0, buffer.length());
                method = span.select("span").text();
                buffer.append(method);
                haystack = buffer.toString();
                calculateBIDASK XCPBTCpoloniex = new calculateBIDASK();

                XCPBTC_poloniex.setBid(XCPBTCpoloniex.getBid(bid1, haystack));
                XCPBTC_poloniex.setAsk(XCPBTCpoloniex.getAsk(ask1, haystack));

                System.out.println("OK XCPBTC_poloniex is" + XCPBTC_poloniex.getBid() + " " + XCPBTC_poloniex.getAsk());

                doc = Jsoup.connect("https://www.investing.com/currencies/ppc-btc?cid=1056686").get();
                span = doc.select("span");
                buffer.delete(0, buffer.length());
                method = span.select("span").text();
                buffer.append(method);
                haystack = buffer.toString();
                calculateBIDASK PPCBTCpoloniex = new calculateBIDASK();

                PPCBTC_poloniex.setBid(PPCBTCpoloniex.getBid(bid1, haystack));
                PPCBTC_poloniex.setAsk(PPCBTCpoloniex.getAsk(ask1, haystack));

                System.out.println("OK PPCBTC_poloniex is" + PPCBTC_poloniex.getBid() + " " + PPCBTC_poloniex.getAsk());

                doc = Jsoup.connect("https://www.investing.com/currencies/burst-btc?cid=1056682").get();
                span = doc.select("span");
                buffer.delete(0, buffer.length());
                method = span.select("span").text();
                buffer.append(method);
                haystack = buffer.toString();
                calculateBIDASK BRSBTCpoloniex = new calculateBIDASK();

                BRSBTC_poloniex.setBid(BRSBTCpoloniex.getBid(bid1, haystack));
                BRSBTC_poloniex.setAsk(BRSBTCpoloniex.getAsk(ask1, haystack));

                System.out.println("OK BRSBTC_poloniex is" + BRSBTC_poloniex.getBid() + " " + BRSBTC_poloniex.getAsk());


                doc = Jsoup.connect("https://www.investing.com/currencies/cvc-btc?cid=1054925").get();
                span = doc.select("span");
                buffer.delete(0, buffer.length());
                method = span.select("span").text();
                buffer.append(method);
                haystack = buffer.toString();
                calculateBIDASK CVCBTCpoloniex = new calculateBIDASK();

                CVCBTC_poloniex.setBid(CVCBTCpoloniex.getBid(bid1, haystack));
                CVCBTC_poloniex.setAsk(CVCBTCpoloniex.getAsk(ask1, haystack));

                System.out.println("OK CVCBTC_poloniex is" + CVCBTC_poloniex.getBid() + " " + CVCBTC_poloniex.getAsk());

                doc = Jsoup.connect("https://www.investing.com/currencies/lbc-btc?cid=1056681").get();
                span = doc.select("span");
                buffer.delete(0, buffer.length());
                method = span.select("span").text();
                buffer.append(method);
                haystack = buffer.toString();
                calculateBIDASK LBCBTCpoloniex = new calculateBIDASK();

                LBCBTC_poloniex.setBid(LBCBTCpoloniex.getBid(bid1, haystack));
                LBCBTC_poloniex.setAsk(LBCBTCpoloniex.getAsk(ask1, haystack));

                System.out.println("OK LBCBTC_poloniex is" + LBCBTC_poloniex.getBid() + " " + LBCBTC_poloniex.getAsk());

                doc = Jsoup.connect("https://www.investing.com/currencies/clam-btc?cid=1056679").get();
                span = doc.select("span");
                buffer.delete(0, buffer.length());
                method = span.select("span").text();
                buffer.append(method);
                haystack = buffer.toString();
                calculateBIDASK CLMBTCpoloniex = new calculateBIDASK();

                CLMBTC_poloniex.setBid(CLMBTCpoloniex.getBid(bid1, haystack));
                CLMBTC_poloniex.setAsk(CLMBTCpoloniex.getAsk(ask1, haystack));

                System.out.println("OK CLMBTC_poloniex is" + CLMBTC_poloniex.getBid() + " " + CLMBTC_poloniex.getAsk());

                doc = Jsoup.connect("https://www.investing.com/currencies/xpm-btc").get();
                span = doc.select("span");
                buffer.delete(0, buffer.length());
                method = span.select("span").text();
                buffer.append(method);
                haystack = buffer.toString();
                calculateBIDASK XPMBTCpoloniex = new calculateBIDASK();

                XPMBTC_poloniex.setBid(XPMBTCpoloniex.getBid(bid1, haystack));
                XPMBTC_poloniex.setAsk(XPMBTCpoloniex.getAsk(ask1, haystack));

                System.out.println("OK XPMBTC_poloniex is" + XPMBTC_poloniex.getBid() + " " + XPMBTC_poloniex.getAsk());

                doc = Jsoup.connect("https://www.investing.com/currencies/omni-btc?cid=1056704").get();
                span = doc.select("span");
                buffer.delete(0, buffer.length());
                method = span.select("span").text();
                buffer.append(method);
                haystack = buffer.toString();
                calculateBIDASK OMNBTCpoloniex = new calculateBIDASK();

                OMNBTC_poloniex.setBid(OMNBTCpoloniex.getBid(bid1, haystack));
                OMNBTC_poloniex.setAsk(OMNBTCpoloniex.getAsk(ask1, haystack));

                System.out.println("OK OMNBTC_poloniex is" + OMNBTC_poloniex.getBid() + " " + OMNBTC_poloniex.getAsk());

                doc = Jsoup.connect("https://www.investing.com/currencies/pot-btc?cid=1056680").get();
                span = doc.select("span");
                buffer.delete(0, buffer.length());
                method = span.select("span").text();
                buffer.append(method);
                haystack = buffer.toString();
                calculateBIDASK POTBTCpoloniex = new calculateBIDASK();

                POTBTC_poloniex.setBid(POTBTCpoloniex.getBid(bid1, haystack));
                POTBTC_poloniex.setAsk(POTBTCpoloniex.getAsk(ask1, haystack));

                System.out.println("OK POTBTC_poloniex is" + POTBTC_poloniex.getBid() + " " + POTBTC_poloniex.getAsk());


                doc = Jsoup.connect("https://www.investing.com/currencies/fldc-btc?cid=1056689").get();
                span = doc.select("span");
                buffer.delete(0, buffer.length());
                method = span.select("span").text();
                buffer.append(method);
                haystack = buffer.toString();
                calculateBIDASK FLDBTCpoloniex = new calculateBIDASK();

                FLDBTC_poloniex.setBid(FLDBTCpoloniex.getBid(bid1, haystack));
                FLDBTC_poloniex.setAsk(FLDBTCpoloniex.getAsk(ask1, haystack));

                System.out.println("OK FLDBTC_poloniex is" + FLDBTC_poloniex.getBid() + " " + FLDBTC_poloniex.getAsk());

                doc = Jsoup.connect("https://www.investing.com/currencies/blk-btc?cid=1056684").get();
                span = doc.select("span");
                buffer.delete(0, buffer.length());
                method = span.select("span").text();
                buffer.append(method);
                haystack = buffer.toString();
                calculateBIDASK BLKBTCpoloniex = new calculateBIDASK();

                BLKBTC_poloniex.setBid(BLKBTCpoloniex.getBid(bid1, haystack));
                BLKBTC_poloniex.setAsk(BLKBTCpoloniex.getAsk(ask1, haystack));

                System.out.println("OK BLKBTC_poloniex is" + BLKBTC_poloniex.getBid() + " " + BLKBTC_poloniex.getAsk());

                doc = Jsoup.connect("https://www.investing.com/currencies/amp-btc?cid=1056685").get();
                span = doc.select("span");
                buffer.delete(0, buffer.length());
                method = span.select("span").text();
                buffer.append(method);
                haystack = buffer.toString();
                calculateBIDASK AMPBTCpoloniex = new calculateBIDASK();

                AMPBTC_poloniex.setBid(AMPBTCpoloniex.getBid(bid1, haystack));
                AMPBTC_poloniex.setAsk(AMPBTCpoloniex.getAsk(ask1, haystack));

                System.out.println("OK AMPBTC_poloniex is" + AMPBTC_poloniex.getBid() + " " + AMPBTC_poloniex.getAsk());

                doc = Jsoup.connect("https://www.investing.com/currencies/flo-btc?cid=1056683").get();
                span = doc.select("span");
                buffer.delete(0, buffer.length());
                method = span.select("span").text();
                buffer.append(method);
                haystack = buffer.toString();
                calculateBIDASK FLOBTCpoloniex = new calculateBIDASK();

                FLOBTC_poloniex.setBid(FLOBTCpoloniex.getBid(bid1, haystack));
                FLOBTC_poloniex.setAsk(FLOBTCpoloniex.getAsk(ask1, haystack));

                System.out.println("OK FLOBTC_poloniex is" + FLOBTC_poloniex.getBid() + " " + FLOBTC_poloniex.getAsk());

                doc = Jsoup.connect("https://www.investing.com/currencies/pink-btc?cid=1056696").get();
                span = doc.select("span");
                buffer.delete(0, buffer.length());
                method = span.select("span").text();
                buffer.append(method);
                haystack = buffer.toString();
                calculateBIDASK PNKBTCpoloniex = new calculateBIDASK();

                PNKBTC_poloniex.setBid(PNKBTCpoloniex.getBid(bid1, haystack));
                PNKBTC_poloniex.setAsk(PNKBTCpoloniex.getAsk(ask1, haystack));

                System.out.println("OK PNKBTC_poloniex is" + PNKBTC_poloniex.getBid() + " " + PNKBTC_poloniex.getAsk());

                doc = Jsoup.connect("https://www.investing.com/currencies/nav-btc").get();
                span = doc.select("span");
                buffer.delete(0, buffer.length());
                method = span.select("span").text();
                buffer.append(method);
                haystack = buffer.toString();
                calculateBIDASK NAVBTCpoloniex = new calculateBIDASK();

                NAVBTC_poloniex.setBid(NAVBTCpoloniex.getBid(bid1, haystack));
                NAVBTC_poloniex.setAsk(NAVBTCpoloniex.getAsk(ask1, haystack));

                System.out.println("OK NAVBTC_poloniex is" + NAVBTC_poloniex.getBid() + " " + NAVBTC_poloniex.getAsk());

                doc = Jsoup.connect("https://www.investing.com/currencies/via-btc?cid=1056694").get();
                span = doc.select("span");
                buffer.delete(0, buffer.length());
                method = span.select("span").text();
                buffer.append(method);
                haystack = buffer.toString();
                calculateBIDASK VIABTCpoloniex = new calculateBIDASK();

                VIABTC_poloniex.setBid(VIABTCpoloniex.getBid(bid1, haystack));
                VIABTC_poloniex.setAsk(VIABTCpoloniex.getAsk(ask1, haystack));

                System.out.println("OK VIABTC_poloniex is" + VIABTC_poloniex.getBid() + " " + VIABTC_poloniex.getAsk());


                doc = Jsoup.connect("https://www.investing.com/currencies/nmc-btc").get();
                span = doc.select("span");
                buffer.delete(0, buffer.length());
                method = span.select("span").text();
                buffer.append(method);
                haystack = buffer.toString();
                calculateBIDASK NMCBTCpoloniex = new calculateBIDASK();

                NMCBTC_poloniex.setBid(NMCBTCpoloniex.getBid(bid1, haystack));
                NMCBTC_poloniex.setAsk(NMCBTCpoloniex.getAsk(ask1, haystack));

                System.out.println("OK NMCBTC_poloniex is" + NMCBTC_poloniex.getBid() + " " + NMCBTC_poloniex.getAsk());


                doc = Jsoup.connect("https://www.investing.com/currencies/nxc-btc?cid=1056691").get();
                span = doc.select("span");
                buffer.delete(0, buffer.length());
                method = span.select("span").text();
                buffer.append(method);
                haystack = buffer.toString();
                calculateBIDASK NXCBTCpoloniex = new calculateBIDASK();

                NXCBTC_poloniex.setBid(NXCBTCpoloniex.getBid(bid1, haystack));
                NXCBTC_poloniex.setAsk(NXCBTCpoloniex.getAsk(ask1, haystack));

                System.out.println("OK NXCBTC_poloniex is" + NXCBTC_poloniex.getBid() + " " + NXCBTC_poloniex.getAsk());

                doc = Jsoup.connect("https://www.investing.com/currencies/grc-btc?cid=1056697").get();
                span = doc.select("span");
                buffer.delete(0, buffer.length());
                method = span.select("span").text();
                buffer.append(method);
                haystack = buffer.toString();
                calculateBIDASK GRCBTCpoloniex = new calculateBIDASK();

                GRCBTC_poloniex.setBid(GRCBTCpoloniex.getBid(bid1, haystack));
                GRCBTC_poloniex.setAsk(GRCBTCpoloniex.getAsk(ask1, haystack));

                System.out.println("OK GRCBTC_poloniex is" + GRCBTC_poloniex.getBid() + " " + GRCBTC_poloniex.getAsk());

                doc = Jsoup.connect("https://www.investing.com/currencies/xbc-btc").get();
                span = doc.select("span");
                buffer.delete(0, buffer.length());
                method = span.select("span").text();
                buffer.append(method);
                haystack = buffer.toString();
                calculateBIDASK XBCBTCpoloniex = new calculateBIDASK();

                XBCBTC_poloniex.setBid(XBCBTCpoloniex.getBid(bid1, haystack));
                XBCBTC_poloniex.setAsk(XBCBTCpoloniex.getAsk(ask1, haystack));

                System.out.println("OK XBCBTC_poloniex is" + XBCBTC_poloniex.getBid() + " " + XBCBTC_poloniex.getAsk());

                doc = Jsoup.connect("https://www.investing.com/currencies/rads-btc?cid=1056700").get();
                span = doc.select("span");
                buffer.delete(0, buffer.length());
                method = span.select("span").text();
                buffer.append(method);
                haystack = buffer.toString();
                calculateBIDASK RDSBTCpoloniex = new calculateBIDASK();

                RDSBTC_poloniex.setBid(RDSBTCpoloniex.getBid(bid1, haystack));
                RDSBTC_poloniex.setAsk(RDSBTCpoloniex.getAsk(ask1, haystack));

                System.out.println("OK RDSBTC_poloniex is" + RDSBTC_poloniex.getBid() + " " + RDSBTC_poloniex.getAsk());


                doc = Jsoup.connect("https://www.investing.com/currencies/neos-btc?cid=1056687").get();
                span = doc.select("span");
                buffer.delete(0, buffer.length());
                method = span.select("span").text();
                buffer.append(method);
                haystack = buffer.toString();
                calculateBIDASK NESBTCpoloniex = new calculateBIDASK();

                NESBTC_poloniex.setBid(NESBTCpoloniex.getBid(bid1, haystack));
                NESBTC_poloniex.setAsk(NESBTCpoloniex.getAsk(ask1, haystack));

                System.out.println("OK NESBTC_poloniex is" + NESBTC_poloniex.getBid() + " " + NESBTC_poloniex.getAsk());

                doc = Jsoup.connect("https://www.investing.com/currencies/btcd-btc?cid=1046285").get();
                span = doc.select("span");
                buffer.delete(0, buffer.length());
                method = span.select("span").text();
                buffer.append(method);
                haystack = buffer.toString();
                calculateBIDASK BTDBTCpoloniex = new calculateBIDASK();

                BTDBTC_poloniex.setBid(BTDBTCpoloniex.getBid(bid1, haystack));
                BTDBTC_poloniex.setAsk(BTDBTCpoloniex.getAsk(ask1, haystack));

                System.out.println("OK BTDBTC_poloniex is" + BTDBTC_poloniex.getBid() + " " + BTDBTC_poloniex.getAsk());

                doc = Jsoup.connect("https://www.investing.com/currencies/xvc-btc?cid=1056695").get();
                span = doc.select("span");
                buffer.delete(0, buffer.length());
                method = span.select("span").text();
                buffer.append(method);
                haystack = buffer.toString();
                calculateBIDASK VCHBTCpoloniex = new calculateBIDASK();

                VCHBTC_poloniex.setBid(VCHBTCpoloniex.getBid(bid1, haystack));
                VCHBTC_poloniex.setAsk(VCHBTCpoloniex.getAsk(ask1, haystack));

                System.out.println("OK VCHBTC_poloniex is" + VCHBTC_poloniex.getBid() + " " + VCHBTC_poloniex.getAsk());

                doc = Jsoup.connect("https://www.investing.com/currencies/huc-btc").get();
                span = doc.select("span");
                buffer.delete(0, buffer.length());
                method = span.select("span").text();
                buffer.append(method);
                haystack = buffer.toString();
                calculateBIDASK HUCBTCpoloniex = new calculateBIDASK();

                HUCBTC_poloniex.setBid(HUCBTCpoloniex.getBid(bid1, haystack));
                HUCBTC_poloniex.setAsk(HUCBTCpoloniex.getAsk(ask1, haystack));

                System.out.println("OK HUCBTC_poloniex is" + HUCBTC_poloniex.getBid() + " " + HUCBTC_poloniex.getAsk());

                doc = Jsoup.connect("https://www.investing.com/currencies/btma-btc").get();
                span = doc.select("span");
                buffer.delete(0, buffer.length());
                method = span.select("span").text();
                buffer.append(method);
                haystack = buffer.toString();
                calculateBIDASK BTMBTCpoloniex = new calculateBIDASK();

                BTMBTC_poloniex.setBid(BTMBTCpoloniex.getBid(bid1, haystack));
                BTMBTC_poloniex.setAsk(BTMBTCpoloniex.getAsk(ask1, haystack));

                System.out.println("OK BTMBTC_poloniex is" + BTMBTC_poloniex.getBid() + " " + BTMBTC_poloniex.getAsk());

                doc = Jsoup.connect("https://www.investing.com/currencies/zec-btc").get();
                span = doc.select("span");
                buffer.delete(0, buffer.length());
                method = span.select("span").text();
                buffer.append(method);
                haystack = buffer.toString();
                calculateBIDASK ZECBTCpoloniex = new calculateBIDASK();

                ZECBTC_poloniex.setBid(ZECBTCpoloniex.getBid(bid1, haystack));
                ZECBTC_poloniex.setAsk(ZECBTCpoloniex.getAsk(ask1, haystack));

                System.out.println("OK ZECBTC_poloniex is" + ZECBTC_poloniex.getBid() + " " + ZECBTC_poloniex.getAsk());

                doc = Jsoup.connect("https://www.investing.com/currencies/etc-eth?cid=1029188").get();
                span = doc.select("span");
                buffer.delete(0, buffer.length());
                method = span.select("span").text();
                buffer.append(method);
                haystack = buffer.toString();
                calculateBIDASK ETCETHpoloniex = new calculateBIDASK();

                ETCETH_poloniex.setBid(ETCETHpoloniex.getBid(bid1, haystack));
                ETCETH_poloniex.setAsk(ETCETHpoloniex.getAsk(ask1, haystack));

                System.out.println("OK ETCETH_poloniex is" + ETCETH_poloniex.getBid() + " " + ETCETH_poloniex.getAsk());

                doc = Jsoup.connect("https://www.investing.com/currencies/bch-eth?cid=1035806").get();
                span = doc.select("span");
                buffer.delete(0, buffer.length());
                method = span.select("span").text();
                buffer.append(method);
                haystack = buffer.toString();
                calculateBIDASK BCHETHpoloniex = new calculateBIDASK();

                BCHETH_poloniex.setBid(BCHETHpoloniex.getBid(bid1, haystack));
                BCHETH_poloniex.setAsk(BCHETHpoloniex.getAsk(ask1, haystack));

                System.out.println("OK BCHETH_poloniex is" + BCHETH_poloniex.getBid() + " " + BCHETH_poloniex.getAsk());

                doc = Jsoup.connect("https://www.investing.com/currencies/zrx-eth").get();
                span = doc.select("span");
                buffer.delete(0, buffer.length());
                method = span.select("span").text();
                buffer.append(method);
                haystack = buffer.toString();
                calculateBIDASK ZRXETHpoloniex = new calculateBIDASK();

                ZRXETH_poloniex.setBid(ZRXETHpoloniex.getBid(bid1, haystack));
                ZRXETH_poloniex.setAsk(ZRXETHpoloniex.getAsk(ask1, haystack));

                System.out.println("OK ZRXETH_poloniex is" + ZRXETH_poloniex.getBid() + " " + ZRXETH_poloniex.getAsk());

                doc = Jsoup.connect("https://www.investing.com/currencies/zec-eth").get();
                span = doc.select("span");
                buffer.delete(0, buffer.length());
                method = span.select("span").text();
                buffer.append(method);
                haystack = buffer.toString();
                calculateBIDASK ZECETHpoloniex = new calculateBIDASK();

                ZECETH_poloniex.setBid(ZECETHpoloniex.getBid(bid1, haystack));
                ZECETH_poloniex.setAsk(ZECETHpoloniex.getAsk(ask1, haystack));

                System.out.println("OK ZECETH_poloniex is" + ZECETH_poloniex.getBid() + " " + ZECETH_poloniex.getAsk());

                doc = Jsoup.connect("https://www.investing.com/currencies/gas-eth").get();
                span = doc.select("span");
                buffer.delete(0, buffer.length());
                method = span.select("span").text();
                buffer.append(method);
                haystack = buffer.toString();
                calculateBIDASK GASETHpoloniex = new calculateBIDASK();

                GASETH_poloniex.setBid(GASETHpoloniex.getBid(bid1, haystack));
                GASETH_poloniex.setAsk(GASETHpoloniex.getAsk(ask1, haystack));

                System.out.println("OK GASETH_poloniex is" + GASETH_poloniex.getBid() + " " + GASETH_poloniex.getAsk());

                doc = Jsoup.connect("https://www.investing.com/currencies/omg-eth?cid=1054900").get();
                span = doc.select("span");
                buffer.delete(0, buffer.length());
                method = span.select("span").text();
                buffer.append(method);
                haystack = buffer.toString();
                calculateBIDASK OMGETHpoloniex = new calculateBIDASK();

                OMGETH_poloniex.setBid(OMGETHpoloniex.getBid(bid1, haystack));
                OMGETH_poloniex.setAsk(OMGETHpoloniex.getAsk(ask1, haystack));

                System.out.println("OK OMGETH_poloniex is" + OMGETH_poloniex.getBid() + " " + OMGETH_poloniex.getAsk());

                doc = Jsoup.connect("https://www.investing.com/currencies/rep-eth?cid=1055904").get();
                span = doc.select("span");
                buffer.delete(0, buffer.length());
                method = span.select("span").text();
                buffer.append(method);
                haystack = buffer.toString();
                calculateBIDASK REPETHpoloniex = new calculateBIDASK();

                REPETH_poloniex.setBid(REPETHpoloniex.getBid(bid1, haystack));
                REPETH_poloniex.setAsk(REPETHpoloniex.getAsk(ask1, haystack));

                System.out.println("OK REPETH_poloniex is" + REPETH_poloniex.getBid() + " " + REPETH_poloniex.getAsk());

                doc = Jsoup.connect("https://www.investing.com/currencies/lsk-eth").get();
                span = doc.select("span");
                buffer.delete(0, buffer.length());
                method = span.select("span").text();
                buffer.append(method);
                haystack = buffer.toString();
                calculateBIDASK LSKETHpoloniex = new calculateBIDASK();

                LSKETH_poloniex.setBid(LSKETHpoloniex.getBid(bid1, haystack));
                LSKETH_poloniex.setAsk(LSKETHpoloniex.getAsk(ask1, haystack));

                System.out.println("OK LSKETH_poloniex is" + LSKETH_poloniex.getBid() + " " + LSKETH_poloniex.getAsk());

                doc = Jsoup.connect("https://www.investing.com/currencies/gno-eth").get();
                span = doc.select("span");
                buffer.delete(0, buffer.length());
                method = span.select("span").text();
                buffer.append(method);
                haystack = buffer.toString();
                calculateBIDASK GNOETHpoloniex = new calculateBIDASK();

                GNOETH_poloniex.setBid(GNOETHpoloniex.getBid(bid1, haystack));
                GNOETH_poloniex.setAsk(GNOETHpoloniex.getAsk(ask1, haystack));

                System.out.println("OK GNOETH_poloniex is" + GNOETH_poloniex.getBid() + " " + GNOETH_poloniex.getAsk());

                doc = Jsoup.connect("https://www.investing.com/currencies/gnt-eth").get();
                span = doc.select("span");
                buffer.delete(0, buffer.length());
                method = span.select("span").text();
                buffer.append(method);
                haystack = buffer.toString();
                calculateBIDASK GNTETHpoloniex = new calculateBIDASK();

                GNTETH_poloniex.setBid(GNTETHpoloniex.getBid(bid1, haystack));
                GNTETH_poloniex.setAsk(GNTETHpoloniex.getAsk(ask1, haystack));

                System.out.println("OK GNTETH_poloniex is" + GNTETH_poloniex.getBid() + " " + GNTETH_poloniex.getAsk());

                doc = Jsoup.connect("https://www.investing.com/currencies/cvc-eth?cid=1054927").get();
                span = doc.select("span");
                buffer.delete(0, buffer.length());
                method = span.select("span").text();
                buffer.append(method);
                haystack = buffer.toString();
                calculateBIDASK CVCETHpoloniex = new calculateBIDASK();

                CVCETH_poloniex.setBid(CVCETHpoloniex.getBid(bid1, haystack));
                CVCETH_poloniex.setAsk(CVCETHpoloniex.getAsk(ask1, haystack));

                System.out.println("OK CVCETH_poloniex is" + CVCETH_poloniex.getBid() + " " + CVCETH_poloniex.getAsk());

                doc = Jsoup.connect("https://www.investing.com/currencies/steem-eth").get();
                span = doc.select("span");
                buffer.delete(0, buffer.length());
                method = span.select("span").text();
                buffer.append(method);
                haystack = buffer.toString();
                calculateBIDASK STMETHpoloniex = new calculateBIDASK();

                STMETH_poloniex.setBid(STMETHpoloniex.getBid(bid1, haystack));
                STMETH_poloniex.setAsk(STMETHpoloniex.getAsk(ask1, haystack));

                System.out.println("OK STMETH_poloniex is" + STMETH_poloniex.getBid() + " " + STMETH_poloniex.getAsk());

                doc = Jsoup.connect("https://www.investing.com/currencies/ltc-xmr").get();
                span = doc.select("span");
                buffer.delete(0, buffer.length());
                method = span.select("span").text();
                buffer.append(method);
                haystack = buffer.toString();
                calculateBIDASK LTCXMRpoloniex = new calculateBIDASK();

                LTCXMR_poloniex.setBid(LTCXMRpoloniex.getBid(bid1, haystack));
                LTCXMR_poloniex.setAsk(LTCXMRpoloniex.getAsk(ask1, haystack));

                System.out.println("OK LTCXMR_poloniex is" + LTCXMR_poloniex.getBid() + " " + LTCXMR_poloniex.getAsk());

                doc = Jsoup.connect("https://www.investing.com/currencies/dash-xmr").get();
                span = doc.select("span");
                buffer.delete(0, buffer.length());
                method = span.select("span").text();
                buffer.append(method);
                haystack = buffer.toString();
                calculateBIDASK DSHXMRpoloniex = new calculateBIDASK();

                DSHXMR_poloniex.setBid(DSHXMRpoloniex.getBid(bid1, haystack));
                DSHXMR_poloniex.setAsk(DSHXMRpoloniex.getAsk(ask1, haystack));

                System.out.println("OK DSHXMR_poloniex is" + DSHXMR_poloniex.getBid() + " " + DSHXMR_poloniex.getAsk());

                doc = Jsoup.connect("https://www.investing.com/currencies/zec-xmr").get();
                span = doc.select("span");
                buffer.delete(0, buffer.length());
                method = span.select("span").text();
                buffer.append(method);
                haystack = buffer.toString();
                calculateBIDASK ZECXMRpoloniex = new calculateBIDASK();

                ZECXMR_poloniex.setBid(ZECXMRpoloniex.getBid(bid1, haystack));
                ZECXMR_poloniex.setAsk(ZECXMRpoloniex.getAsk(ask1, haystack));

                System.out.println("OK ZECXMR_poloniex is" + ZECXMR_poloniex.getBid() + " " + ZECXMR_poloniex.getAsk());

                doc = Jsoup.connect("https://www.investing.com/currencies/nxt-xmr").get();
                span = doc.select("span");
                buffer.delete(0, buffer.length());
                method = span.select("span").text();
                buffer.append(method);
                haystack = buffer.toString();
                calculateBIDASK NXTXMRpoloniex = new calculateBIDASK();

                NXTXMR_poloniex.setBid(NXTXMRpoloniex.getBid(bid1, haystack));
                NXTXMR_poloniex.setAsk(NXTXMRpoloniex.getAsk(ask1, haystack));

                System.out.println("OK NXTXMR_poloniex is" + NXTXMR_poloniex.getBid() + " " + NXTXMR_poloniex.getAsk());

                doc = Jsoup.connect("https://www.investing.com/currencies/storj-btc?cid=1054924").get();
                span = doc.select("span");
                buffer.delete(0, buffer.length());
                method = span.select("span").text();
                buffer.append(method);
                haystack = buffer.toString();
                calculateBIDASK STJBTCpoloniex = new calculateBIDASK();

                STJBTC_poloniex.setBid(STJBTCpoloniex.getBid(bid1, haystack));
                STJBTC_poloniex.setAsk(STJBTCpoloniex.getAsk(ask1, haystack));

                System.out.println("OK STJBTC_poloniex is" + STJBTC_poloniex.getBid() + " " + STJBTC_poloniex.getAsk());

                doc = Jsoup.connect("https://www.investing.com/currencies/xlm-btc?cid=1036945").get();
                span = doc.select("span");
                buffer.delete(0, buffer.length());
                method = span.select("span").text();
                buffer.append(method);
                haystack = buffer.toString();
                calculateBIDASK XLMBTCpoloniex = new calculateBIDASK();

                XLMBTC_poloniex.setBid(XLMBTCpoloniex.getBid(bid1, haystack));
                XLMBTC_poloniex.setAsk(XLMBTCpoloniex.getAsk(ask1, haystack));

                System.out.println("OK XLMBTC_poloniex is" + XLMBTC_poloniex.getBid() + " " + XLMBTC_poloniex.getAsk());


                doc = Jsoup.connect("https://www.investing.com/currencies/bcy-btc?cid=1056702").get();
                span = doc.select("span");
                buffer.delete(0, buffer.length());
                method = span.select("span").text();
                buffer.append(method);
                haystack = buffer.toString();
                calculateBIDASK BCYBTCpoloniex = new calculateBIDASK();

                BCYBTC_poloniex.setBid(BCYBTCpoloniex.getBid(bid1, haystack));
                BCYBTC_poloniex.setAsk(BCYBTCpoloniex.getAsk(ask1, haystack));

                System.out.println("OK BCYBTC_poloniex is" + BCYBTC_poloniex.getBid() + " " + BCYBTC_poloniex.getAsk());

                doc = Jsoup.connect("https://www.investing.com/currencies/sys-btc?cid=1036947").get();
                span = doc.select("span");
                buffer.delete(0, buffer.length());
                method = span.select("span").text();
                buffer.append(method);
                haystack = buffer.toString();
                calculateBIDASK SYSBTCpoloniex = new calculateBIDASK();

                SYSBTC_poloniex.setBid(SYSBTCpoloniex.getBid(bid1, haystack));
                SYSBTC_poloniex.setAsk(SYSBTCpoloniex.getAsk(ask1, haystack));

                System.out.println("OK SYSBTC_poloniex is" + SYSBTC_poloniex.getBid() + " " + SYSBTC_poloniex.getAsk());


                doc = Jsoup.connect("https://www.investing.com/currencies/xrp-btc").get();
                span = doc.select("span");
                buffer.delete(0, buffer.length());
                method = span.select("span").text();
                buffer.append(method);
                haystack = buffer.toString();
                calculateBIDASK XRPBTCpoloniex = new calculateBIDASK();


                XRPBTC_poloniex.setBid(XRPBTCpoloniex.getBid(bid1, haystack));
                XRPBTC_poloniex.setAsk(XRPBTCpoloniex.getAsk(ask1, haystack));

                System.out.println("OK XRPBTC_poloniex is" + XRPBTC_poloniex.getBid() + " " + XRPBTC_poloniex.getAsk());

                doc = Jsoup.connect("https://www.investing.com/currencies/xrp-btc?cid=1054876").get();
                span = doc.select("span");
                buffer.delete(0, buffer.length());
                method = span.select("span").text();
                buffer.append(method);
                haystack = buffer.toString();
                calculateBIDASK XRPBTCbinance = new calculateBIDASK();

                XRPBTC_binance.setBid(XRPBTCbinance.getBid(bid1, haystack));
                XRPBTC_binance.setAsk(XRPBTCbinance.getAsk(ask1, haystack));

                System.out.println("OK XRPBTC_binance is" + XRPBTC_binance.getBid() + " " + XRPBTC_binance.getAsk());

                doc = Jsoup.connect("https://www.investing.com/currencies/xrp-btc?cid=1010787").get();
                span = doc.select("span");
                buffer.delete(0, buffer.length());
                method = span.select("span").text();
                buffer.append(method);
                haystack = buffer.toString();
                calculateBIDASK XRPBTCkraken = new calculateBIDASK();

                XRPBTC_kraken.setBid(XRPBTCkraken.getBid(bid1, haystack));
                XRPBTC_kraken.setAsk(XRPBTCkraken.getAsk(ask1, haystack));

                System.out.println("OK XRPBTC_kraken is" + XRPBTC_kraken.getBid() + " " + XRPBTC_kraken.getAsk());

                doc = Jsoup.connect("https://www.investing.com/currencies/xrp-eth?cid=1055882").get();
                span = doc.select("span");
                buffer.delete(0, buffer.length());
                method = span.select("span").text();
                buffer.append(method);
                haystack = buffer.toString();
                calculateBIDASK XRPETHbinance = new calculateBIDASK();

                XRPETH_binance.setBid(XRPETHbinance.getBid(bid1, haystack));
                XRPETH_binance.setAsk(XRPETHbinance.getAsk(ask1, haystack));

                System.out.println("OK XRPETH_binance is" + XRPETH_binance.getBid() + " " + XRPETH_binance.getAsk());

                doc = Jsoup.connect("https://www.investing.com/currencies/xmr-btc").get();
                span = doc.select("span");
                buffer.delete(0, buffer.length());
                method = span.select("span").text();
                buffer.append(method);
                haystack = buffer.toString();
                calculateBIDASK XMRBTCpoloniex = new calculateBIDASK();

                XMRBTC_poloniex.setBid(XMRBTCpoloniex.getBid(bid1, haystack));
                XMRBTC_poloniex.setAsk(XMRBTCpoloniex.getAsk(ask1, haystack));

                System.out.println("OK XMRBTC_poloniex is" + XMRBTC_poloniex.getBid() + " " + XMRBTC_poloniex.getAsk());

                doc = Jsoup.connect("https://www.investing.com/currencies/xmr-btc?cid=1054882").get();
                span = doc.select("span");
                buffer.delete(0, buffer.length());
                method = span.select("span").text();
                buffer.append(method);
                haystack = buffer.toString();
                calculateBIDASK XMRBTCbinance = new calculateBIDASK();

                XMRBTC_binance.setBid(XMRBTCbinance.getBid(bid1, haystack));
                XMRBTC_binance.setAsk(XMRBTCbinance.getAsk(ask1, haystack));

                System.out.println("OK XMRBTC_binance is" + XMRBTC_binance.getBid() + " " + XMRBTC_binance.getAsk());

                doc = Jsoup.connect("https://www.investing.com/currencies/xmr-btc?cid=1024868").get();
                span = doc.select("span");
                buffer.delete(0, buffer.length());
                method = span.select("span").text();
                buffer.append(method);
                haystack = buffer.toString();
                calculateBIDASK XMRBTCkraken = new calculateBIDASK();

                XMRBTC_kraken.setBid(XMRBTCkraken.getBid(bid1, haystack));
                XMRBTC_kraken.setAsk(XMRBTCkraken.getAsk(ask1, haystack));

                System.out.println("OK XMRBTC_kraken is" + XMRBTC_kraken.getBid() + " " + XMRBTC_kraken.getAsk());

                doc = Jsoup.connect("https://www.investing.com/currencies/gno-btc?cid=1056980").get();
                span = doc.select("span");
                buffer.delete(0, buffer.length());
                method = span.select("span").text();
                buffer.append(method);
                haystack = buffer.toString();
                calculateBIDASK GNOBTCkraken = new calculateBIDASK();

                GNOBTC_kraken.setBid(GNOBTCkraken.getBid(bid1, haystack));
                GNOBTC_kraken.setAsk(GNOBTCkraken.getAsk(ask1, haystack));

                System.out.println("OK GNOBTC_kraken is" + GNOBTC_kraken.getBid() + " " + GNOBTC_kraken.getAsk());


                doc = Jsoup.connect("https://www.investing.com/currencies/eth-btc?cid=1055001").get();
                span = doc.select("span");
                buffer.delete(0, buffer.length());
                method = span.select("span").text();
                buffer.append(method);
                haystack = buffer.toString();
                calculateBIDASK ETHBTCgemini = new calculateBIDASK();

                ETHBTC_gemini.setBid(ETHBTCgemini.getBid(bid1, haystack));
                ETHBTC_gemini.setAsk(ETHBTCgemini.getAsk(ask1, haystack));

                System.out.println("OK ETHBTC_gemini is" + ETHBTC_gemini.getBid() + " " + ETHBTC_gemini.getAsk());


                doc = Jsoup.connect("https://www.investing.com/currencies/xlm-btc?cid=1037018").get();
                span = doc.select("span");
                buffer.delete(0, buffer.length());
                method = span.select("span").text();
                buffer.append(method);
                haystack = buffer.toString();
                calculateBIDASK XLMBTCkraken = new calculateBIDASK();

                XLMBTC_kraken.setBid(XLMBTCkraken.getBid(bid1, haystack));
                XLMBTC_kraken.setAsk(XLMBTCkraken.getAsk(ask1, haystack));

                System.out.println("OK XLMBTC_kraken is" + XLMBTC_kraken.getBid() + " " + XLMBTC_kraken.getAsk());


                doc = Jsoup.connect("https://www.investing.com/currencies/mln-btc?cid=1054922").get();
                span = doc.select("span");
                buffer.delete(0, buffer.length());
                method = span.select("span").text();
                buffer.append(method);
                haystack = buffer.toString();
                calculateBIDASK MLNBTCkraken = new calculateBIDASK();

                MLNBTC_kraken.setBid(MLNBTCkraken.getBid(bid1, haystack));
                MLNBTC_kraken.setAsk(MLNBTCkraken.getAsk(ask1, haystack));

                System.out.println("OK MLNBTC_kraken is" + MLNBTC_kraken.getBid() + " " + MLNBTC_kraken.getAsk());


                doc = Jsoup.connect("https://www.investing.com/currencies/icn-eth?cid=1037019").get();
                span = doc.select("span");
                buffer.delete(0, buffer.length());
                method = span.select("span").text();
                buffer.append(method);
                haystack = buffer.toString();
                calculateBIDASK ICNETHkraken = new calculateBIDASK();

                ICNETH_kraken.setBid(ICNETHkraken.getBid(bid1, haystack));
                ICNETH_kraken.setAsk(ICNETHkraken.getAsk(ask1, haystack));

                System.out.println("OK ICNETH_kraken is" + ICNETH_kraken.getBid() + " " + ICNETH_kraken.getAsk());

                doc = Jsoup.connect("https://www.investing.com/currencies/etc-eth").get();
                span = doc.select("span");
                buffer.delete(0, buffer.length());
                method = span.select("span").text();
                buffer.append(method);
                haystack = buffer.toString();
                calculateBIDASK ETCETHkraken = new calculateBIDASK();

                ETCETH_kraken.setBid(ETCETHkraken.getBid(bid1, haystack));
                ETCETH_kraken.setAsk(ETCETHkraken.getAsk(ask1, haystack));

                System.out.println("OK ETCETH_kraken is" + ETCETH_kraken.getBid() + " " + ETCETH_kraken.getAsk());


                doc = Jsoup.connect("https://www.investing.com/currencies/zec-btc?cid=1029171").get();
                span = doc.select("span");
                buffer.delete(0, buffer.length());
                method = span.select("span").text();
                buffer.append(method);
                haystack = buffer.toString();
                calculateBIDASK ZECBTCkraken = new calculateBIDASK();

                ZECBTC_kraken.setBid(ZECBTCkraken.getBid(bid1, haystack));
                ZECBTC_kraken.setAsk(ZECBTCkraken.getAsk(ask1, haystack));

                System.out.println("OK ZECBTC_kraken is" + ZECBTC_kraken.getBid() + " " + ZECBTC_kraken.getAsk());

                doc = Jsoup.connect("https://www.investing.com/currencies/gno-eth?cid=1056983").get();
                span = doc.select("span");
                buffer.delete(0, buffer.length());
                method = span.select("span").text();
                buffer.append(method);
                haystack = buffer.toString();
                calculateBIDASK GNOETHkraken = new calculateBIDASK();

                GNOETH_kraken.setBid(GNOETHkraken.getBid(bid1, haystack));
                GNOETH_kraken.setAsk(GNOETHkraken.getAsk(ask1, haystack));

                System.out.println("OK GNOETH_kraken is" + GNOETH_kraken.getBid() + " " + GNOETH_kraken.getAsk());

                doc = Jsoup.connect("https://www.investing.com/currencies/rep-btc?cid=1037021").get();
                span = doc.select("span");
                buffer.delete(0, buffer.length());
                method = span.select("span").text();
                buffer.append(method);
                haystack = buffer.toString();
                calculateBIDASK REPBTCkraken = new calculateBIDASK();

                REPBTC_kraken.setBid(REPBTCkraken.getBid(bid1, haystack));
                REPBTC_kraken.setAsk(REPBTCkraken.getAsk(ask1, haystack));

                System.out.println("OK REPBTC_kraken is" + REPBTC_kraken.getBid() + " " + REPBTC_kraken.getAsk());


                doc = Jsoup.connect("https://www.investing.com/currencies/icn-btc").get();
                span = doc.select("span");
                buffer.delete(0, buffer.length());
                method = span.select("span").text();
                buffer.append(method);
                haystack = buffer.toString();
                calculateBIDASK ICNBTCkraken = new calculateBIDASK();

                ICNBTC_kraken.setBid(ICNBTCkraken.getBid(bid1, haystack));
                ICNBTC_kraken.setAsk(ICNBTCkraken.getAsk(ask1, haystack));

                System.out.println("OK ICNBTC_kraken is" + ICNBTC_kraken.getBid() + " " + ICNBTC_kraken.getAsk());

                doc = Jsoup.connect("https://www.investing.com/currencies/etc-btc?cid=1029168").get();
                span = doc.select("span");
                buffer.delete(0, buffer.length());
                method = span.select("span").text();
                buffer.append(method);
                haystack = buffer.toString();
                calculateBIDASK ETCBTCkraken = new calculateBIDASK();

                ETCBTC_kraken.setBid(ETCBTCkraken.getBid(bid1, haystack));
                ETCBTC_kraken.setAsk(ETCBTCkraken.getAsk(ask1, haystack));

                System.out.println("OK ETCBTC_kraken is" + ETCBTC_kraken.getBid() + " " + ETCBTC_kraken.getAsk());


                doc = Jsoup.connect("https://www.investing.com/currencies/ltc-btc?cid=1029166").get();
                span = doc.select("span");
                buffer.delete(0, buffer.length());
                method = span.select("span").text();
                buffer.append(method);
                haystack = buffer.toString();
                calculateBIDASK LTCBTCkraken = new calculateBIDASK();

                LTCBTC_kraken.setBid(LTCBTCkraken.getBid(bid1, haystack));
                LTCBTC_kraken.setAsk(LTCBTCkraken.getAsk(ask1, haystack));

                System.out.println("OK LTCBTC_kraken is" + LTCBTC_kraken.getBid() + " " + LTCBTC_kraken.getAsk());

                doc = Jsoup.connect("https://www.investing.com/currencies/eth-eos").get();
                span = doc.select("span");
                buffer.delete(0, buffer.length());
                method = span.select("span").text();
                buffer.append(method);
                haystack = buffer.toString();
                calculateBIDASK ETHEOSkraken = new calculateBIDASK();

                ETHEOS_kraken.setBid(ETHEOSkraken.getBid(bid1, haystack));
                ETHEOS_kraken.setAsk(ETHEOSkraken.getAsk(ask1, haystack));

                System.out.println("OK ETHEOS_kraken is" + ETHEOS_kraken.getBid() + " " + ETHEOS_kraken.getAsk());


                doc = Jsoup.connect("https://www.investing.com/currencies/bch-btc?cid=1031086").get();
                span = doc.select("span");
                buffer.delete(0, buffer.length());
                method = span.select("span").text();
                buffer.append(method);
                haystack = buffer.toString();
                calculateBIDASK BCHBTCkraken = new calculateBIDASK();

                BCHBTC_kraken.setBid(BCHBTCkraken.getBid(bid1, haystack));
                BCHBTC_kraken.setAsk(BCHBTCkraken.getAsk(ask1, haystack));

                System.out.println("OK BCHBTC_kraken is" + BCHBTC_kraken.getBid() + " " + BCHBTC_kraken.getAsk());


                doc = Jsoup.connect("https://www.investing.com/currencies/ltc-btc?cid=1010800").get();
                span = doc.select("span");
                buffer.delete(0, buffer.length());
                method = span.select("span").text();
                buffer.append(method);
                haystack = buffer.toString();
                calculateBIDASK LTCBTCgdax = new calculateBIDASK();

                LTCBTC_gdax.setBid(LTCBTCgdax.getBid(bid1, haystack));
                LTCBTC_gdax.setAsk(LTCBTCgdax.getAsk(ask1, haystack));

                System.out.println("OK LTCBTC_gdax is" + LTCBTC_gdax.getBid() + " " + LTCBTC_gdax.getAsk());


                doc = Jsoup.connect("https://www.investing.com/currencies/eos-eth?cid=1024866").get();
                span = doc.select("span");
                buffer.delete(0, buffer.length());
                method = span.select("span").text();
                buffer.append(method);
                haystack = buffer.toString();
                calculateBIDASK EOSETHkraken = new calculateBIDASK();

                EOSETH_kraken.setBid(EOSETHkraken.getBid(bid1, haystack));
                EOSETH_kraken.setAsk(EOSETHkraken.getAsk(ask1, haystack));

                System.out.println("OK EOSETH_kraken is" + EOSETH_kraken.getBid() + " " + EOSETH_kraken.getAsk());


                doc = Jsoup.connect("https://www.investing.com/currencies/dash-btc?cid=1010790").get();
                span = doc.select("span");
                buffer.delete(0, buffer.length());
                method = span.select("span").text();
                buffer.append(method);
                haystack = buffer.toString();
                calculateBIDASK DSHBTCraken = new calculateBIDASK();

                DSHBTC_kraken.setBid(DSHBTCraken.getBid(bid1, haystack));
                DSHBTC_kraken.setAsk(DSHBTCraken.getAsk(ask1, haystack));

                System.out.println("OK DSHBTC_kraken is" + DSHBTC_kraken.getBid() + " " + DSHBTC_kraken.getAsk());


                doc = Jsoup.connect("https://www.investing.com/currencies/xmr-eth?cid=1054897").get();
                span = doc.select("span");
                buffer.delete(0, buffer.length());
                method = span.select("span").text();
                buffer.append(method);
                haystack = buffer.toString();
                calculateBIDASK XMRETHbinance = new calculateBIDASK();

                XMRETH_binance.setBid(XMRETHbinance.getBid(bid1, haystack));
                XMRETH_binance.setAsk(XMRETHbinance.getAsk(ask1, haystack));

                System.out.println("OK XMRETH_binance is" + XMRETH_binance.getBid() + " " + XMRETH_binance.getAsk());

                //Triangular Arbitrage Spreads
                triangularArbitrage();


            } catch (Exception e) {
                e.printStackTrace();
            }

            return buffer.toString();

        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);

            String buffer = s;

            Toast.makeText(getApplicationContext(), "Arbitrage Spreads Calculated", LENGTH_LONG).show();
            text.setText(optimalPathText);

        }

    }

    private void triangularArbitrage() {

        //TriArb


        Field[] fld = MainActivity.class.getDeclaredFields();
        String pair[] = new String[fld.length];
        System.out.println("CHECK");
        for (int i = 0; i < fld.length; i++) {

            pair[i] = fld[i].getName();
            System.out.println(i + "   " + pair[i]);

        }

        //Make sure that the max length a b c must reach is the quantity of currency pairs being calculated
        for (int a = 0; a <= 102; a++) {

            c1 = pair[a];

            for (int b = 0; b <= 102; b++) {

                c2 = pair[b];

                for (int c = 0; c <= 102; c++) {

                    c3 = pair[c];

                    z++;

                    // Compare base currency with quote currency to secure round-trip triangular arbitrage
                    if (
                            (  // Path 1
                                    (c1.substring(3, 6).equals(c2.substring(0, 3)) && c2.substring(3, 6).equals(c3.substring(0, 3)))
                                            && (c1.substring(0, 3).equals(c3.substring(3, 6))))

                                    ||
                                    (   // Path 2
                                            (c1.substring(3, 6).equals(c2.substring(0, 3)) && c2.substring(3, 6).equals(c3.substring(3, 6)))
                                                    && (c1.substring(0, 3).equals(c3.substring(0, 3))))

                                    ||
                                    (   // Path 3
                                            (c1.substring(3, 6).equals(c2.substring(3, 6)) && c2.substring(0, 3).equals(c3.substring(0, 3)))
                                                    && (c1.substring(0, 3).equals(c3.substring(3, 6))))

                                    ||
                                    (// Path 4
                                            (c1.substring(3, 6).equals(c2.substring(3, 6)) && c2.substring(0, 3).equals(c3.substring(3, 6)))
                                                    && (c1.substring(0, 3).equals(c3.substring(0, 3))))

                                    ||
                                    (   // Path 5
                                            (c1.substring(0, 3).equals(c2.substring(0, 3)) && c2.substring(3, 6).equals(c3.substring(0, 3)))
                                                    && (c1.substring(3, 6).equals(c3.substring(3, 6))))
                                    ||

                                    (   // Path 6
                                            (c1.substring(0, 3).equals(c2.substring(0, 3)) && c2.substring(3, 6).equals(c3.substring(3, 6)))
                                                    && (c1.substring(3, 6).equals(c3.substring(0, 3))))

                                    ||
                                    (   // Path 7
                                            (c1.substring(0, 3).equals(c2.substring(3, 6)) && c2.substring(0, 3).equals(c3.substring(0, 3)))
                                                    && (c1.substring(3, 6).equals(c3.substring(3, 6))))

                                    ||
                                    (   // Path 8
                                            (c1.substring(0, 3).equals(c2.substring(3, 6)) && c2.substring(0, 3).equals(c3.substring(3, 6)))
                                                    && (c1.substring(3, 6).equals(c3.substring(0, 3))))
                            ) {


                        //

                        // cd1 cd2 cd3  BRUTE FORCE

                        if (c1.equalsIgnoreCase("ETHBTC_poloniex")) {

                            cd1b = ETHBTC_poloniex.getBid();
                            cd1a = ETHBTC_poloniex.getAsk();

                        }
/*
                        if(c1.equalsIgnoreCase("ETHBTC_cexio")){

                            cd1b = ETHBTC_cexio.getBid();
                            cd1a = ETHBTC_cexio.getAsk();

                        }*/

                        if (c1.equalsIgnoreCase("ETHBTC_binance")) {

                            cd1b = ETHBTC_binance.getBid();
                            cd1a = ETHBTC_binance.getAsk();

                        }

                        if (c1.equalsIgnoreCase("ETHBTC_kraken")) {

                            cd1b = ETHBTC_kraken.getBid();
                            cd1a = ETHBTC_kraken.getAsk();

                        }


                        if (c1.equalsIgnoreCase("ETHBTC_gdax")) {

                            cd1b = ETHBTC_gdax.getBid();
                            cd1a = ETHBTC_gdax.getAsk();

                        }


                        if (c1.equalsIgnoreCase("XLMBTC_poloniex")) {

                            cd1b = XLMBTC_poloniex.getBid();
                            cd1a = XLMBTC_poloniex.getAsk();

                        }

                        if (c1.equalsIgnoreCase("STJBTC_poloniex")) {

                            cd1b = STJBTC_poloniex.getBid();
                            cd1a = STJBTC_poloniex.getAsk();

                        }

                        if (c1.equalsIgnoreCase("ZECXMR_poloniex")) {

                            cd1b = ZECXMR_poloniex.getBid();
                            cd1a = ZECXMR_poloniex.getAsk();

                        }

                        if (c1.equalsIgnoreCase("DSHXMR_poloniex")) {

                            cd1b = DSHXMR_poloniex.getBid();
                            cd1a = DSHXMR_poloniex.getAsk();

                        }

                        if (c1.equalsIgnoreCase("LTCXMR_poloniex")) {

                            cd1b = LTCXMR_poloniex.getBid();
                            cd1a = LTCXMR_poloniex.getAsk();

                        }

                        if (c1.equalsIgnoreCase("STMETH_poloniex")) {

                            cd1b = STMETH_poloniex.getBid();
                            cd1a = STMETH_poloniex.getAsk();

                        }

                        if (c1.equalsIgnoreCase("CVCETH_poloniex")) {

                            cd1b = CVCETH_poloniex.getBid();
                            cd1a = CVCETH_poloniex.getAsk();

                        }

                        if (c1.equalsIgnoreCase("GNTETH_poloniex")) {

                            cd1b = GNTETH_poloniex.getBid();
                            cd1a = GNTETH_poloniex.getAsk();

                        }

                        if (c1.equalsIgnoreCase("GNOETH_poloniex")) {

                            cd1b = GNOETH_poloniex.getBid();
                            cd1a = GNOETH_poloniex.getAsk();

                        }

                        if (c1.equalsIgnoreCase("LSKETH_poloniex")) {

                            cd1b = LSKETH_poloniex.getBid();
                            cd1a = LSKETH_poloniex.getAsk();

                        }

                        if (c1.equalsIgnoreCase("REPETH_poloniex")) {

                            cd1b = REPETH_poloniex.getBid();
                            cd1a = REPETH_poloniex.getAsk();

                        }


                        if (c1.equalsIgnoreCase("OMGETH_poloniex")) {

                            cd1b = OMGETH_poloniex.getBid();
                            cd1a = OMGETH_poloniex.getAsk();

                        }


                        if (c1.equalsIgnoreCase("GASETH_poloniex")) {

                            cd1b = GASETH_poloniex.getBid();
                            cd1a = GASETH_poloniex.getAsk();

                        }


                        if (c1.equalsIgnoreCase("ZECETH_poloniex")) {

                            cd1b = ZECETH_poloniex.getBid();
                            cd1a = ZECETH_poloniex.getAsk();

                        }


                        if (c1.equalsIgnoreCase("ZRXETH_poloniex")) {

                            cd1b = ZRXETH_poloniex.getBid();
                            cd1a = ZRXETH_poloniex.getAsk();

                        }


                        if (c1.equalsIgnoreCase("BCHETH_poloniex")) {

                            cd1b = BCHETH_poloniex.getBid();
                            cd1a = BCHETH_poloniex.getAsk();

                        }


                        if (c1.equalsIgnoreCase("ETCETH_poloniex")) {

                            cd1b = ETCETH_poloniex.getBid();
                            cd1a = ETCETH_poloniex.getAsk();

                        }


                        if (c1.equalsIgnoreCase("ZECBTC_poloniex")) {

                            cd1b = ZECBTC_poloniex.getBid();
                            cd1a = ZECBTC_poloniex.getAsk();

                        }

                        if (c1.equalsIgnoreCase("BTMBTC_poloniex")) {

                            cd1b = BTMBTC_poloniex.getBid();
                            cd1a = BTMBTC_poloniex.getAsk();

                        }

                        if (c1.equalsIgnoreCase("HUCBTC_poloniex")) {

                            cd1b = HUCBTC_poloniex.getBid();
                            cd1a = HUCBTC_poloniex.getAsk();

                        }

                        if (c1.equalsIgnoreCase("VCHBTC_poloniex")) {

                            cd1b = VCHBTC_poloniex.getBid();
                            cd1a = VCHBTC_poloniex.getAsk();

                        }

                        if (c1.equalsIgnoreCase("BTDBTC_poloniex")) {

                            cd1b = BTDBTC_poloniex.getBid();
                            cd1a = BTDBTC_poloniex.getAsk();

                        }

                        if (c1.equalsIgnoreCase("NESBTC_poloniex")) {

                            cd1b = NESBTC_poloniex.getBid();
                            cd1a = NESBTC_poloniex.getAsk();

                        }

                        if (c1.equalsIgnoreCase("RDSBTC_poloniex")) {

                            cd1b = RDSBTC_poloniex.getBid();
                            cd1a = RDSBTC_poloniex.getAsk();

                        }


                        if (c1.equalsIgnoreCase("XBCBTC_poloniex")) {

                            cd1b = XBCBTC_poloniex.getBid();
                            cd1a = XBCBTC_poloniex.getAsk();

                        }

                        if (c1.equalsIgnoreCase("BCYBTC_poloniex")) {

                            cd1b = BCYBTC_poloniex.getBid();
                            cd1a = BCYBTC_poloniex.getAsk();

                        }

                        if (c1.equalsIgnoreCase("GRCBTC_poloniex")) {

                            cd1b = GRCBTC_poloniex.getBid();
                            cd1a = GRCBTC_poloniex.getAsk();

                        }

                        if (c1.equalsIgnoreCase("NXCBTC_poloniex")) {

                            cd1b = NXCBTC_poloniex.getBid();
                            cd1a = NXCBTC_poloniex.getAsk();

                        }

                        if (c1.equalsIgnoreCase("NMCBTC_poloniex")) {

                            cd1b = NMCBTC_poloniex.getBid();
                            cd1a = NMCBTC_poloniex.getAsk();

                        }

                        if (c1.equalsIgnoreCase("VIABTC_poloniex")) {

                            cd1b = VIABTC_poloniex.getBid();
                            cd1a = VIABTC_poloniex.getAsk();

                        }

                        if (c1.equalsIgnoreCase("NAVBTC_poloniex")) {

                            cd1b = NAVBTC_poloniex.getBid();
                            cd1a = NAVBTC_poloniex.getAsk();

                        }


                        if (c1.equalsIgnoreCase("PNKBTC_poloniex")) {

                            cd1b = PNKBTC_poloniex.getBid();
                            cd1a = PNKBTC_poloniex.getAsk();

                        }

                        if (c1.equalsIgnoreCase("FLOBTC_poloniex")) {

                            cd1b = FLOBTC_poloniex.getBid();
                            cd1a = FLOBTC_poloniex.getAsk();

                        }

                        if (c1.equalsIgnoreCase("AMPBTC_poloniex")) {

                            cd1b = AMPBTC_poloniex.getBid();
                            cd1a = AMPBTC_poloniex.getAsk();

                        }

                        if (c1.equalsIgnoreCase("BLKBTC_poloniex")) {

                            cd1b = BLKBTC_poloniex.getBid();
                            cd1a = BLKBTC_poloniex.getAsk();

                        }

                        if (c1.equalsIgnoreCase("FLDBTC_poloniex")) {

                            cd1b = FLDBTC_poloniex.getBid();
                            cd1a = FLDBTC_poloniex.getAsk();

                        }

                        if (c1.equalsIgnoreCase("POTBTC_poloniex")) {

                            cd1b = POTBTC_poloniex.getBid();
                            cd1a = POTBTC_poloniex.getAsk();

                        }

                        if (c1.equalsIgnoreCase("OMNBTC_poloniex")) {

                            cd1b = OMNBTC_poloniex.getBid();
                            cd1a = OMNBTC_poloniex.getAsk();

                        }

                        if (c1.equalsIgnoreCase("XPMBTC_poloniex")) {

                            cd1b = XPMBTC_poloniex.getBid();
                            cd1a = XPMBTC_poloniex.getAsk();

                        }

                        if (c1.equalsIgnoreCase("CLMBTC_poloniex")) {

                            cd1b = CLMBTC_poloniex.getBid();
                            cd1a = CLMBTC_poloniex.getAsk();

                        }

                        if (c1.equalsIgnoreCase("LBCBTC_poloniex")) {

                            cd1b = LBCBTC_poloniex.getBid();
                            cd1a = LBCBTC_poloniex.getAsk();

                        }

                        if (c1.equalsIgnoreCase("CVCBTC_poloniex")) {

                            cd1b = CVCBTC_poloniex.getBid();
                            cd1a = CVCBTC_poloniex.getAsk();

                        }

                        if (c1.equalsIgnoreCase("BRSBTC_poloniex")) {

                            cd1b = BRSBTC_poloniex.getBid();
                            cd1a = BRSBTC_poloniex.getAsk();

                        }

                        if (c1.equalsIgnoreCase("PPCBTC_poloniex")) {

                            cd1b = PPCBTC_poloniex.getBid();
                            cd1a = PPCBTC_poloniex.getAsk();

                        }

                        if (c1.equalsIgnoreCase("XCPBTC_poloniex")) {

                            cd1b = XCPBTC_poloniex.getBid();
                            cd1a = XCPBTC_poloniex.getAsk();

                        }


                        if (c1.equalsIgnoreCase("VRCBTC_poloniex")) {

                            cd1b = VRCBTC_poloniex.getBid();
                            cd1a = VRCBTC_poloniex.getAsk();

                        }

                        if (c1.equalsIgnoreCase("GNOBTC_poloniex")) {

                            cd1b = GNOBTC_poloniex.getBid();
                            cd1a = GNOBTC_poloniex.getAsk();

                        }

                        if (c1.equalsIgnoreCase("SYSBTC_poloniex")) {

                            cd1b = SYSBTC_poloniex.getBid();
                            cd1a = SYSBTC_poloniex.getAsk();

                        }

                        if (c1.equalsIgnoreCase("EMCBTC_poloniex")) {

                            cd1b = EMCBTC_poloniex.getBid();
                            cd1a = EMCBTC_poloniex.getAsk();

                        }

                        if (c1.equalsIgnoreCase("VTCBTC_poloniex")) {

                            cd1b = VTCBTC_poloniex.getBid();
                            cd1a = VTCBTC_poloniex.getAsk();

                        }

                        if (c1.equalsIgnoreCase("DCRBTC_poloniex")) {

                            cd1b = DCRBTC_poloniex.getBid();
                            cd1a = DCRBTC_poloniex.getAsk();

                        }

                        if (c1.equalsIgnoreCase("GASBTC_poloniex")) {

                            cd1b = GASBTC_poloniex.getBid();
                            cd1a = GASBTC_poloniex.getAsk();

                        }

                        if (c1.equalsIgnoreCase("EXPBTC_poloniex")) {

                            cd1b = EXPBTC_poloniex.getBid();
                            cd1a = EXPBTC_poloniex.getAsk();

                        }

                        if (c1.equalsIgnoreCase("GNTBTC_poloniex")) {

                            cd1b = GNTBTC_poloniex.getBid();
                            cd1a = GNTBTC_poloniex.getAsk();

                        }

                        if (c1.equalsIgnoreCase("PASBTC_poloniex")) {

                            cd1b = PASBTC_poloniex.getBid();
                            cd1a = PASBTC_poloniex.getAsk();

                        }


                        if (c1.equalsIgnoreCase("ARRBTC_poloniex")) {

                            cd1b = ARRBTC_poloniex.getBid();
                            cd1a = ARRBTC_poloniex.getAsk();

                        }


                        if (c1.equalsIgnoreCase("MADBTC_poloniex")) {

                            cd1b = MADBTC_poloniex.getBid();
                            cd1a = MADBTC_poloniex.getAsk();

                        }

                        if (c1.equalsIgnoreCase("NMEBTC_poloniex")) {

                            cd1b = NMEBTC_poloniex.getBid();
                            cd1a = NMEBTC_poloniex.getAsk();

                        }

                        if (c1.equalsIgnoreCase("GMEBTC_poloniex")) {

                            cd1b = GMEBTC_poloniex.getBid();
                            cd1a = GMEBTC_poloniex.getAsk();

                        }

                        if (c1.equalsIgnoreCase("RICBTC_poloniex")) {

                            cd1b = RICBTC_poloniex.getBid();
                            cd1a = RICBTC_poloniex.getAsk();

                        }

                        if (c1.equalsIgnoreCase("REPBTC_poloniex")) {

                            cd1b = REPBTC_poloniex.getBid();
                            cd1a = REPBTC_poloniex.getAsk();

                        }

                        if (c1.equalsIgnoreCase("STMBTC_poloniex")) {

                            cd1b = STMBTC_poloniex.getBid();
                            cd1a = STMBTC_poloniex.getAsk();

                        }

                        if (c1.equalsIgnoreCase("OMGBTC_poloniex")) {

                            cd1b = OMGBTC_poloniex.getBid();
                            cd1a = OMGBTC_poloniex.getAsk();

                        }


                        if (c1.equalsIgnoreCase("STTBTC_poloniex")) {

                            cd1b = STTBTC_poloniex.getBid();
                            cd1a = STTBTC_poloniex.getAsk();

                        }


                        if (c1.equalsIgnoreCase("LSKBTC_poloniex")) {

                            cd1b = LSKBTC_poloniex.getBid();
                            cd1a = LSKBTC_poloniex.getAsk();

                        }


                        if (c1.equalsIgnoreCase("ZRXBTC_poloniex")) {

                            cd1b = ZRXBTC_poloniex.getBid();
                            cd1a = ZRXBTC_poloniex.getAsk();

                        }

                        if (c1.equalsIgnoreCase("SCXBTC_poloniex")) {

                            cd1b = SCXBTC_poloniex.getBid();
                            cd1a = SCXBTC_poloniex.getAsk();

                        }


                        if (c1.equalsIgnoreCase("DSHBTC_poloniex")) {

                            cd1b = DSHBTC_poloniex.getBid();
                            cd1a = DSHBTC_poloniex.getAsk();

                        }


                        if (c1.equalsIgnoreCase("BCHBTC_poloniex")) {

                            cd1b = BCHBTC_poloniex.getBid();
                            cd1a = BCHBTC_poloniex.getAsk();

                        }

                        if (c1.equalsIgnoreCase("ETCBTC_poloniex")) {

                            cd1b = ETCBTC_poloniex.getBid();
                            cd1a = ETCBTC_poloniex.getAsk();

                        }

                        if (c1.equalsIgnoreCase("XEMBTC_poloniex")) {

                            cd1b = XEMBTC_poloniex.getBid();
                            cd1a = XEMBTC_poloniex.getAsk();

                        }

                        if (c1.equalsIgnoreCase("BTSBTC_poloniex")) {

                            cd1b = BTSBTC_poloniex.getBid();
                            cd1a = BTSBTC_poloniex.getAsk();

                        }

                        if (c1.equalsIgnoreCase("LTCBTC_poloniex")) {

                            cd1b = LTCBTC_poloniex.getBid();
                            cd1a = LTCBTC_poloniex.getAsk();

                        }


                        if (c1.equalsIgnoreCase("BCHBTC_kraken")) {

                            cd1b = BCHBTC_kraken.getBid();
                            cd1a = BCHBTC_kraken.getAsk();

                        }


                        if (c1.equalsIgnoreCase("REPBTC_kraken")) {

                            cd1b = REPBTC_kraken.getBid();
                            cd1a = REPBTC_kraken.getAsk();

                        }


                        if (c1.equalsIgnoreCase("ICNBTC_kraken")) {

                            cd1b = ICNBTC_kraken.getBid();
                            cd1a = ICNBTC_kraken.getAsk();

                        }


                        if (c1.equalsIgnoreCase("XLMBTC_kraken")) {

                            cd1b = XLMBTC_kraken.getBid();
                            cd1a = XLMBTC_kraken.getAsk();

                        }


                        if (c1.equalsIgnoreCase("XRPBTC_poloniex")) {

                            cd1b = XRPBTC_poloniex.getBid();
                            cd1a = XRPBTC_poloniex.getAsk();

                        }

                        if (c1.equalsIgnoreCase("XRPBTC_binance")) {

                            cd1b = XRPBTC_binance.getBid();
                            cd1a = XRPBTC_binance.getAsk();

                        }

                        if (c1.equalsIgnoreCase("XRPBTC_kraken")) {

                            cd1b = XRPBTC_kraken.getBid();
                            cd1a = XRPBTC_kraken.getAsk();

                        }

                        if (c1.equalsIgnoreCase("EOSETH_kraken")) {

                            cd1b = EOSETH_kraken.getBid();
                            cd1a = EOSETH_kraken.getAsk();

                        }

                        if (c1.equalsIgnoreCase("XRPETH_binance")) {

                            cd1b = XRPETH_binance.getBid();
                            cd1a = XRPETH_binance.getAsk();


                        }

                        if (c1.equalsIgnoreCase("ETCBTC_kraken")) {

                            cd1b = ETCBTC_kraken.getBid();
                            cd1a = ETCBTC_kraken.getAsk();

                        }


                        if (c1.equalsIgnoreCase("XMRBTC_poloniex")) {

                            cd1b = XMRBTC_poloniex.getBid();
                            cd1a = XMRBTC_poloniex.getAsk();

                        }

                        if (c1.equalsIgnoreCase("XMRBTC_binance")) {

                            cd1b = XMRBTC_binance.getBid();
                            cd1a = XMRBTC_binance.getAsk();

                        }

                        if (c1.equalsIgnoreCase("ETHBTC_gemini")) {

                            cd1b = ETHBTC_gemini.getBid();
                            cd1a = ETHBTC_gemini.getAsk();

                        }

                        if (c1.equalsIgnoreCase("DSHBTC_kraken")) {

                            cd1b = DSHBTC_kraken.getBid();
                            cd1a = DSHBTC_kraken.getAsk();

                        }

                        if (c1.equalsIgnoreCase("XMRBTC_kraken")) {

                            cd1b = XMRBTC_kraken.getBid();
                            cd1a = XMRBTC_kraken.getAsk();

                        }


                        if (c1.equalsIgnoreCase("ETHEOS_kraken")) {

                            cd1b = ETHEOS_kraken.getBid();
                            cd1a = ETHEOS_kraken.getAsk();

                        }


                        if (c1.equalsIgnoreCase("ETCETH_kraken")) {

                            cd1b = ETCETH_kraken.getBid();
                            cd1a = ETCETH_kraken.getAsk();

                        }


                        if (c1.equalsIgnoreCase("ZECBTC_kraken")) {

                            cd1b = ZECBTC_kraken.getBid();
                            cd1a = ZECBTC_kraken.getAsk();

                        }


                        if (c1.equalsIgnoreCase("GNOETH_kraken")) {

                            cd1b = GNOETH_kraken.getBid();
                            cd1a = GNOETH_kraken.getAsk();

                        }


                        if (c1.equalsIgnoreCase("LTCBTC_kraken")) {

                            cd1b = LTCBTC_kraken.getBid();
                            cd1a = LTCBTC_kraken.getAsk();

                        }


                        if (c1.equalsIgnoreCase("MLNBTC_kraken")) {

                            cd1b = MLNBTC_kraken.getBid();
                            cd1a = MLNBTC_kraken.getAsk();

                        }

                        if (c1.equalsIgnoreCase("LTCBTC_gdax")) {

                            cd1b = LTCBTC_gdax.getBid();
                            cd1a = LTCBTC_gdax.getAsk();

                        }


                        if (c1.equalsIgnoreCase("ETHBTC_gdax")) {

                            cd1b = ETHBTC_gdax.getBid();
                            cd1a = ETHBTC_gdax.getAsk();

                        }


                        if (c1.equalsIgnoreCase("ICNETH_kraken")) {

                            cd1b = ICNETH_kraken.getBid();
                            cd1a = ICNETH_kraken.getAsk();

                        }


                        if (c1.equalsIgnoreCase("GNOBTC_kraken")) {

                            cd1b = GNOBTC_kraken.getBid();
                            cd1a = GNOBTC_kraken.getAsk();

                        }

                        if (c1.equalsIgnoreCase("XMRETH_binance")) {

                            cd1b = XMRETH_binance.getBid();
                            cd1a = XMRETH_binance.getAsk();

                        }

                        // CD2

                        if (c2.equalsIgnoreCase("ETHBTC_poloniex")) {

                            cd2b = ETHBTC_poloniex.getBid();
                            cd2a = ETHBTC_poloniex.getAsk();

                        }
/*
                        if(c2.equalsIgnoreCase("ETHBTC_cexio")){

                            cd2b = ETHBTC_cexio.getBid();
                            cd2a = ETHBTC_cexio.getAsk();

                        }
*/
                        if (c2.equalsIgnoreCase("ETHBTC_binance")) {

                            cd2b = ETHBTC_binance.getBid();
                            cd2a = ETHBTC_binance.getAsk();

                        }

                        if (c2.equalsIgnoreCase("ETHBTC_kraken")) {

                            cd2b = ETHBTC_kraken.getBid();
                            cd2a = ETHBTC_kraken.getAsk();

                        }


                        if (c2.equalsIgnoreCase("ETHBTC_gdax")) {

                            cd2b = ETHBTC_gdax.getBid();
                            cd2a = ETHBTC_gdax.getAsk();

                        }


                        if (c2.equalsIgnoreCase("MADBTC_poloniex")) {

                            cd2b = MADBTC_poloniex.getBid();
                            cd2a = MADBTC_poloniex.getAsk();

                        }

                        if (c1.equalsIgnoreCase("NXTXMR_poloniex")) {

                            cd1b = NXTXMR_poloniex.getBid();
                            cd1a = NXTXMR_poloniex.getAsk();

                        }


                        if (c2.equalsIgnoreCase("RICBTC_poloniex")) {

                            cd2b = RICBTC_poloniex.getBid();
                            cd2a = RICBTC_poloniex.getAsk();

                        }

                        if (c2.equalsIgnoreCase("LTCBTC_poloniex")) {

                            cd2b = LTCBTC_poloniex.getBid();
                            cd2a = LTCBTC_poloniex.getAsk();

                        }

                        if (c2.equalsIgnoreCase("FLDBTC_poloniex")) {

                            cd2b = FLDBTC_poloniex.getBid();
                            cd2a = FLDBTC_poloniex.getAsk();

                        }

                        if (c2.equalsIgnoreCase("STJBTC_poloniex")) {

                            cd2b = STJBTC_poloniex.getBid();
                            cd2a = STJBTC_poloniex.getAsk();

                        }

                        if (c2.equalsIgnoreCase("NXTXMR_poloniex")) {

                            cd2b = NXTXMR_poloniex.getBid();
                            cd2a = NXTXMR_poloniex.getAsk();

                        }

                        if (c2.equalsIgnoreCase("ZECXMR_poloniex")) {

                            cd2b = ZECXMR_poloniex.getBid();
                            cd2a = ZECXMR_poloniex.getAsk();

                        }

                        if (c2.equalsIgnoreCase("DSHXMR_poloniex")) {

                            cd2b = DSHXMR_poloniex.getBid();
                            cd2a = DSHXMR_poloniex.getAsk();

                        }

                        if (c2.equalsIgnoreCase("LTCXMR_poloniex")) {

                            cd2b = LTCXMR_poloniex.getBid();
                            cd2a = LTCXMR_poloniex.getAsk();

                        }

                        if (c2.equalsIgnoreCase("CVCETH_poloniex")) {

                            cd2b = CVCETH_poloniex.getBid();
                            cd2a = CVCETH_poloniex.getAsk();

                        }

                        if (c2.equalsIgnoreCase("GNTETH_poloniex")) {

                            cd2b = GNTETH_poloniex.getBid();
                            cd2a = GNTETH_poloniex.getAsk();

                        }

                        if (c2.equalsIgnoreCase("GNOETH_poloniex")) {

                            cd2b = GNOETH_poloniex.getBid();
                            cd2a = GNOETH_poloniex.getAsk();

                        }

                        if (c2.equalsIgnoreCase("LSKETH_poloniex")) {

                            cd2b = LSKETH_poloniex.getBid();
                            cd2a = LSKETH_poloniex.getAsk();

                        }

                        if (c2.equalsIgnoreCase("REPETH_poloniex")) {

                            cd2b = REPETH_poloniex.getBid();
                            cd2a = REPETH_poloniex.getAsk();

                        }

                        if (c2.equalsIgnoreCase("OMGETH_poloniex")) {

                            cd2b = OMGETH_poloniex.getBid();
                            cd2a = OMGETH_poloniex.getAsk();

                        }

                        if (c2.equalsIgnoreCase("GASETH_poloniex")) {

                            cd2b = GASETH_poloniex.getBid();
                            cd2a = GASETH_poloniex.getAsk();

                        }


                        if (c2.equalsIgnoreCase("ZECETH_poloniex")) {

                            cd2b = ZECETH_poloniex.getBid();
                            cd2a = ZECETH_poloniex.getAsk();

                        }

                        if (c2.equalsIgnoreCase("BCHETH_poloniex")) {

                            cd2b = BCHETH_poloniex.getBid();
                            cd2a = BCHETH_poloniex.getAsk();

                        }

                        if (c2.equalsIgnoreCase("BTMBTC_poloniex")) {

                            cd2b = BTMBTC_poloniex.getBid();
                            cd2a = BTMBTC_poloniex.getAsk();

                        }


                        if (c2.equalsIgnoreCase("HUCBTC_poloniex")) {

                            cd2b = HUCBTC_poloniex.getBid();
                            cd2a = HUCBTC_poloniex.getAsk();

                        }

                        if (c2.equalsIgnoreCase("VCHBTC_poloniex")) {

                            cd2b = VCHBTC_poloniex.getBid();
                            cd2a = VCHBTC_poloniex.getAsk();

                        }


                        if (c2.equalsIgnoreCase("BTDBTC_poloniex")) {

                            cd2b = BTDBTC_poloniex.getBid();
                            cd2a = BTDBTC_poloniex.getAsk();

                        }


                        if (c2.equalsIgnoreCase("RDSBTC_poloniex")) {

                            cd2b = RDSBTC_poloniex.getBid();
                            cd2a = RDSBTC_poloniex.getAsk();

                        }


                        if (c2.equalsIgnoreCase("XBCBTC_poloniex")) {

                            cd2b = XBCBTC_poloniex.getBid();
                            cd2a = XBCBTC_poloniex.getAsk();

                        }


                        if (c2.equalsIgnoreCase("BCYBTC_poloniex")) {

                            cd2b = BCYBTC_poloniex.getBid();
                            cd2a = BCYBTC_poloniex.getAsk();

                        }

                        if (c2.equalsIgnoreCase("NXCBTC_poloniex")) {

                            cd2b = NXCBTC_poloniex.getBid();
                            cd2a = NXCBTC_poloniex.getAsk();

                        }

                        if (c2.equalsIgnoreCase("NMCBTC_poloniex")) {

                            cd2b = NMCBTC_poloniex.getBid();
                            cd2a = NMCBTC_poloniex.getAsk();

                        }

                        if (c2.equalsIgnoreCase("VIABTC_poloniex")) {

                            cd2b = VIABTC_poloniex.getBid();
                            cd2a = VIABTC_poloniex.getAsk();

                        }

                        if (c2.equalsIgnoreCase("NAVBTC_poloniex")) {

                            cd2b = NAVBTC_poloniex.getBid();
                            cd2a = NAVBTC_poloniex.getAsk();

                        }


                        if (c2.equalsIgnoreCase("FLOBTC_poloniex")) {

                            cd2b = FLOBTC_poloniex.getBid();
                            cd2a = FLOBTC_poloniex.getAsk();

                        }

                        if (c2.equalsIgnoreCase("AMPBTC_poloniex")) {

                            cd2b = AMPBTC_poloniex.getBid();
                            cd2a = AMPBTC_poloniex.getAsk();

                        }


                        if (c2.equalsIgnoreCase("OMNBTC_poloniex")) {

                            cd2b = OMNBTC_poloniex.getBid();
                            cd2a = OMNBTC_poloniex.getAsk();

                        }

                        if (c2.equalsIgnoreCase("XPMBTC_poloniex")) {

                            cd2b = XPMBTC_poloniex.getBid();
                            cd2a = XPMBTC_poloniex.getAsk();

                        }

                        if (c2.equalsIgnoreCase("PPCBTC_poloniex")) {

                            cd2b = PPCBTC_poloniex.getBid();
                            cd2a = PPCBTC_poloniex.getAsk();

                        }


                        if (c2.equalsIgnoreCase("XCPBTC_poloniex")) {

                            cd2b = XCPBTC_poloniex.getBid();
                            cd2a = XCPBTC_poloniex.getAsk();

                        }


                        if (c2.equalsIgnoreCase("SYSBTC_poloniex")) {

                            cd2b = SYSBTC_poloniex.getBid();
                            cd2a = SYSBTC_poloniex.getAsk();

                        }


                        if (c2.equalsIgnoreCase("VTCBTC_poloniex")) {

                            cd2b = VTCBTC_poloniex.getBid();
                            cd2a = VTCBTC_poloniex.getAsk();

                        }

                        if (c3.equalsIgnoreCase("PPCBTC_poloniex")) {

                            cd3b = PPCBTC_poloniex.getBid();
                            cd3a = PPCBTC_poloniex.getAsk();

                        }


                        if (c2.equalsIgnoreCase("DCRBTC_poloniex")) {

                            cd2b = DCRBTC_poloniex.getBid();
                            cd2a = DCRBTC_poloniex.getAsk();

                        }

                        if (c2.equalsIgnoreCase("EXPBTC_poloniex")) {

                            cd2b = EXPBTC_poloniex.getBid();
                            cd2a = EXPBTC_poloniex.getAsk();

                        }


                        if (c2.equalsIgnoreCase("ARRBTC_poloniex")) {

                            cd2b = ARRBTC_poloniex.getBid();
                            cd2a = ARRBTC_poloniex.getAsk();

                        }

                        if (c2.equalsIgnoreCase("STTBTC_poloniex")) {

                            cd2b = STTBTC_poloniex.getBid();
                            cd2a = STTBTC_poloniex.getAsk();

                        }

                        if (c2.equalsIgnoreCase("BTSBTC_poloniex")) {

                            cd2b = BTSBTC_poloniex.getBid();
                            cd2a = BTSBTC_poloniex.getAsk();

                        }

                        if (c2.equalsIgnoreCase("XLMBTC_poloniex")) {

                            cd2b = XLMBTC_poloniex.getBid();
                            cd2a = XLMBTC_poloniex.getAsk();

                        }


                        if (c2.equalsIgnoreCase("STMETH_poloniex")) {

                            cd2b = STMETH_poloniex.getBid();
                            cd2a = STMETH_poloniex.getAsk();

                        }


                        if (c2.equalsIgnoreCase("ZECBTC_poloniex")) {

                            cd2b = ZECBTC_poloniex.getBid();
                            cd2a = ZECBTC_poloniex.getAsk();

                        }

                        if (c2.equalsIgnoreCase("NESBTC_poloniex")) {

                            cd2b = NESBTC_poloniex.getBid();
                            cd2a = NESBTC_poloniex.getAsk();

                        }


                        if (c2.equalsIgnoreCase("GRCBTC_poloniex")) {

                            cd2b = GRCBTC_poloniex.getBid();
                            cd2a = GRCBTC_poloniex.getAsk();

                        }

                        if (c2.equalsIgnoreCase("PNKBTC_poloniex")) {

                            cd2b = PNKBTC_poloniex.getBid();
                            cd2a = PNKBTC_poloniex.getAsk();

                        }

                        if (c2.equalsIgnoreCase("CLMBTC_poloniex")) {

                            cd2b = CLMBTC_poloniex.getBid();
                            cd2a = CLMBTC_poloniex.getAsk();

                        }

                        if (c2.equalsIgnoreCase("LBCBTC_poloniex")) {

                            cd2b = LBCBTC_poloniex.getBid();
                            cd2a = LBCBTC_poloniex.getAsk();

                        }

                        if (c2.equalsIgnoreCase("CVCBTC_poloniex")) {

                            cd2b = CVCBTC_poloniex.getBid();
                            cd2a = CVCBTC_poloniex.getAsk();

                        }

                        if (c2.equalsIgnoreCase("BRSBTC_poloniex")) {

                            cd2b = BRSBTC_poloniex.getBid();
                            cd2a = BRSBTC_poloniex.getAsk();

                        }


                        if (c2.equalsIgnoreCase("VRCBTC_poloniex")) {

                            cd2b = VRCBTC_poloniex.getBid();
                            cd2a = VRCBTC_poloniex.getAsk();

                        }

                        if (c2.equalsIgnoreCase("GNOBTC_poloniex")) {

                            cd2b = GNOBTC_poloniex.getBid();
                            cd2a = GNOBTC_poloniex.getAsk();

                        }

                        if (c2.equalsIgnoreCase("OMGBTC_poloniex")) {

                            cd2b = OMGBTC_poloniex.getBid();
                            cd2a = OMGBTC_poloniex.getAsk();

                        }


                        if (c2.equalsIgnoreCase("ZRXBTC_poloniex")) {

                            cd2b = ZRXBTC_poloniex.getBid();
                            cd2a = ZRXBTC_poloniex.getAsk();

                        }

                        if (c2.equalsIgnoreCase("ETCETH_poloniex")) {

                            cd2b = ETCETH_poloniex.getBid();
                            cd2a = ETCETH_poloniex.getAsk();

                        }


                        if (c2.equalsIgnoreCase("BLKBTC_poloniex")) {

                            cd2b = BLKBTC_poloniex.getBid();
                            cd2a = BLKBTC_poloniex.getAsk();

                        }

                        if (c2.equalsIgnoreCase("POTBTC_poloniex")) {

                            cd2b = POTBTC_poloniex.getBid();
                            cd2a = POTBTC_poloniex.getAsk();

                        }


                        if (c2.equalsIgnoreCase("EMCBTC_poloniex")) {

                            cd2b = EMCBTC_poloniex.getBid();
                            cd2a = EMCBTC_poloniex.getAsk();

                        }

                        if (c2.equalsIgnoreCase("GASBTC_poloniex")) {

                            cd2b = GASBTC_poloniex.getBid();
                            cd2a = GASBTC_poloniex.getAsk();

                        }


                        if (c2.equalsIgnoreCase("GNTBTC_poloniex")) {

                            cd2b = GNTBTC_poloniex.getBid();
                            cd2a = GNTBTC_poloniex.getAsk();

                        }


                        if (c2.equalsIgnoreCase("PASBTC_poloniex")) {

                            cd2b = PASBTC_poloniex.getBid();
                            cd2a = PASBTC_poloniex.getAsk();

                        }

                        if (c2.equalsIgnoreCase("NMEBTC_poloniex")) {

                            cd2b = NMEBTC_poloniex.getBid();
                            cd2a = NMEBTC_poloniex.getAsk();

                        }


                        if (c2.equalsIgnoreCase("GMEBTC_poloniex")) {

                            cd2b = GMEBTC_poloniex.getBid();
                            cd2a = GMEBTC_poloniex.getAsk();

                        }


                        if (c2.equalsIgnoreCase("REPBTC_poloniex")) {

                            cd2b = REPBTC_poloniex.getBid();
                            cd2a = REPBTC_poloniex.getAsk();

                        }


                        if (c2.equalsIgnoreCase("LSKBTC_poloniex")) {

                            cd2b = LSKBTC_poloniex.getBid();
                            cd2a = LSKBTC_poloniex.getAsk();

                        }


                        if (c2.equalsIgnoreCase("SCXBTC_poloniex")) {

                            cd2b = SCXBTC_poloniex.getBid();
                            cd2a = SCXBTC_poloniex.getAsk();

                        }

                        if (c2.equalsIgnoreCase("ETCBTC_poloniex")) {

                            cd2b = ETCBTC_poloniex.getBid();
                            cd2a = ETCBTC_poloniex.getAsk();

                        }

                        if (c2.equalsIgnoreCase("STMBTC_poloniex")) {

                            cd2b = STMBTC_poloniex.getBid();
                            cd2a = STMBTC_poloniex.getAsk();

                        }

                        if (c2.equalsIgnoreCase("DSHBTC_poloniex")) {

                            cd2b = DSHBTC_poloniex.getBid();
                            cd2a = DSHBTC_poloniex.getAsk();

                        }


                        if (c2.equalsIgnoreCase("BCHBTC_poloniex")) {

                            cd2b = BCHBTC_poloniex.getBid();
                            cd2a = BCHBTC_poloniex.getAsk();

                        }


                        if (c2.equalsIgnoreCase("ZRXETH_poloniex")) {

                            cd2b = ZRXETH_poloniex.getBid();
                            cd2a = ZRXETH_poloniex.getAsk();

                        }

                        if (c2.equalsIgnoreCase("XEMBTC_poloniex")) {

                            cd2b = XEMBTC_poloniex.getBid();
                            cd2a = XEMBTC_poloniex.getAsk();

                        }

                        if (c2.equalsIgnoreCase("BCHBTC_kraken")) {

                            cd2b = BCHBTC_kraken.getBid();
                            cd2a = BCHBTC_kraken.getAsk();

                        }


                        if (c2.equalsIgnoreCase("REPBTC_kraken")) {

                            cd2b = REPBTC_kraken.getBid();
                            cd2a = REPBTC_kraken.getAsk();

                        }


                        if (c2.equalsIgnoreCase("XRPBTC_poloniex")) {

                            cd2b = XRPBTC_poloniex.getBid();
                            cd2a = XRPBTC_poloniex.getAsk();

                        }

                        if (c2.equalsIgnoreCase("ICNBTC_kraken")) {

                            cd2b = ICNBTC_kraken.getBid();
                            cd2a = ICNBTC_kraken.getAsk();

                        }


                        if (c2.equalsIgnoreCase("XRPBTC_binance")) {

                            cd2b = XRPBTC_binance.getBid();
                            cd2a = XRPBTC_binance.getAsk();

                        }


                        if (c2.equalsIgnoreCase("XRPBTC_kraken")) {

                            cd2b = XRPBTC_kraken.getBid();
                            cd2a = XRPBTC_kraken.getAsk();

                        }

                        if (c2.equalsIgnoreCase("XRPETH_binance")) {

                            cd2b = XRPETH_binance.getBid();
                            cd2a = XRPETH_binance.getAsk();

                        }


                        if (c2.equalsIgnoreCase("XMRBTC_poloniex")) {

                            cd2b = XMRBTC_poloniex.getBid();
                            cd2a = XMRBTC_poloniex.getAsk();

                        }

                        if (c2.equalsIgnoreCase("XMRBTC_binance")) {

                            cd2b = XMRBTC_binance.getBid();
                            cd2a = XMRBTC_binance.getAsk();

                        }


                        if (c2.equalsIgnoreCase("ZECBTC_kraken")) {

                            cd2b = ZECBTC_kraken.getBid();
                            cd2a = ZECBTC_kraken.getAsk();

                        }

                        if (c2.equalsIgnoreCase("XMRBTC_kraken")) {

                            cd2b = XMRBTC_kraken.getBid();
                            cd2a = XMRBTC_kraken.getAsk();

                        }

                        if (c2.equalsIgnoreCase("XLMBTC_kraken")) {

                            cd2b = XLMBTC_kraken.getBid();
                            cd2a = XLMBTC_kraken.getAsk();

                        }


                        if (c2.equalsIgnoreCase("ETCBTC_kraken")) {

                            cd2b = ETCBTC_kraken.getBid();
                            cd2a = ETCBTC_kraken.getAsk();

                        }


                        if (c2.equalsIgnoreCase("ETCETH_kraken")) {

                            cd2b = ETCETH_kraken.getBid();
                            cd2a = ETCETH_kraken.getAsk();

                        }


                        if (c2.equalsIgnoreCase("EOSETH_kraken")) {

                            cd2b = EOSETH_kraken.getBid();
                            cd2a = EOSETH_kraken.getAsk();

                        }


                        if (c2.equalsIgnoreCase("LTCBTC_kraken")) {

                            cd2b = LTCBTC_kraken.getBid();
                            cd2a = LTCBTC_kraken.getAsk();

                        }

                        if (c2.equalsIgnoreCase("ETHBTC_gemini")) {

                            cd2b = ETHBTC_gemini.getBid();
                            cd2a = ETHBTC_gemini.getAsk();

                        }


                        if (c2.equalsIgnoreCase("ETHBTC_gdax")) {

                            cd2b = ETHBTC_gdax.getBid();
                            cd2a = ETHBTC_gdax.getAsk();

                        }


                        if (c2.equalsIgnoreCase("DSHBTC_kraken")) {

                            cd2b = DSHBTC_kraken.getBid();
                            cd2a = DSHBTC_kraken.getAsk();

                        }


                        if (c2.equalsIgnoreCase("MLNBTC_kraken")) {

                            cd2b = MLNBTC_kraken.getBid();
                            cd2a = MLNBTC_kraken.getAsk();

                        }


                        if (c2.equalsIgnoreCase("ICNETH_kraken")) {

                            cd2b = ICNETH_kraken.getBid();
                            cd2a = ICNETH_kraken.getAsk();

                        }

                        if (c2.equalsIgnoreCase("GNOBTC_kraken")) {

                            cd2b = GNOBTC_kraken.getBid();
                            cd2a = GNOBTC_kraken.getAsk();

                        }


                        if (c2.equalsIgnoreCase("XMRETH_binance")) {

                            cd2b = XMRETH_binance.getBid();
                            cd2a = XMRETH_binance.getAsk();

                        }


                        if (c2.equalsIgnoreCase("LTCBTC_gdax")) {

                            cd2b = LTCBTC_gdax.getBid();
                            cd2a = LTCBTC_gdax.getAsk();

                        }

                        if (c2.equalsIgnoreCase("ETHEOS_kraken")) {

                            cd2b = ETHEOS_kraken.getBid();
                            cd2a = ETHEOS_kraken.getAsk();

                        }


                        if (c2.equalsIgnoreCase("GNOETH_kraken")) {

                            cd2b = GNOETH_kraken.getBid();
                            cd2a = GNOETH_kraken.getAsk();

                        }

                        //  CD3

                        if (c3.equalsIgnoreCase("ETHBTC_poloniex")) {

                            cd3b = ETHBTC_poloniex.getBid();
                            cd3a = ETHBTC_poloniex.getAsk();

                        }

                        if (c3.equalsIgnoreCase("ETHBTC_binance")) {

                            cd3b = ETHBTC_binance.getBid();
                            cd3a = ETHBTC_binance.getAsk();

                        }


                        if (c3.equalsIgnoreCase("HUCBTC_poloniex")) {

                            cd3b = HUCBTC_poloniex.getBid();
                            cd3a = HUCBTC_poloniex.getAsk();

                        }

                        if (c3.equalsIgnoreCase("STJBTC_poloniex")) {

                            cd3b = STJBTC_poloniex.getBid();
                            cd3a = STJBTC_poloniex.getAsk();

                        }


                        if (c3.equalsIgnoreCase("ZECXMR_poloniex")) {

                            cd3b = ZECXMR_poloniex.getBid();
                            cd3a = ZECXMR_poloniex.getAsk();

                        }

                        if (c3.equalsIgnoreCase("GNTETH_poloniex")) {

                            cd3b = GNTETH_poloniex.getBid();
                            cd3a = GNTETH_poloniex.getAsk();

                        }


                        if (c3.equalsIgnoreCase("GNOETH_poloniex")) {

                            cd3b = GNOETH_poloniex.getBid();
                            cd3a = GNOETH_poloniex.getAsk();

                        }

                        if (c3.equalsIgnoreCase("NXCBTC_poloniex")) {

                            cd3b = NXCBTC_poloniex.getBid();
                            cd3a = NXCBTC_poloniex.getAsk();

                        }

                        if (c3.equalsIgnoreCase("GNOBTC_poloniex")) {

                            cd3b = GNOBTC_poloniex.getBid();
                            cd3a = GNOBTC_poloniex.getAsk();

                        }

                        if (c3.equalsIgnoreCase("RDSBTC_poloniex")) {

                            cd3b = RDSBTC_poloniex.getBid();
                            cd3a = RDSBTC_poloniex.getAsk();

                        }

                        if (c3.equalsIgnoreCase("RICBTC_poloniex")) {

                            cd3b = RICBTC_poloniex.getBid();
                            cd3a = RICBTC_poloniex.getAsk();

                        }

                        if (c3.equalsIgnoreCase("SYSBTC_poloniex")) {

                            cd3b = SYSBTC_poloniex.getBid();
                            cd3a = SYSBTC_poloniex.getAsk();

                        }


                        if (c3.equalsIgnoreCase("VTCBTC_poloniex")) {

                            cd3b = VTCBTC_poloniex.getBid();
                            cd3a = VTCBTC_poloniex.getAsk();

                        }


                        if (c3.equalsIgnoreCase("BCYBTC_poloniex")) {

                            cd3b = BCYBTC_poloniex.getBid();
                            cd3a = BCYBTC_poloniex.getAsk();

                        }


                        if (c3.equalsIgnoreCase("FLDBTC_poloniex")) {

                            cd3b = FLDBTC_poloniex.getBid();
                            cd3a = FLDBTC_poloniex.getAsk();

                        }

                        if (c3.equalsIgnoreCase("AMPBTC_poloniex")) {

                            cd3b = AMPBTC_poloniex.getBid();
                            cd3a = AMPBTC_poloniex.getAsk();

                        }

                        if (c3.equalsIgnoreCase("BLKBTC_poloniex")) {

                            cd3b = BLKBTC_poloniex.getBid();
                            cd3a = BLKBTC_poloniex.getAsk();

                        }

                        if (c3.equalsIgnoreCase("POTBTC_poloniex")) {

                            cd3b = POTBTC_poloniex.getBid();
                            cd3a = POTBTC_poloniex.getAsk();

                        }

                        if (c3.equalsIgnoreCase("GASBTC_poloniex")) {

                            cd3b = GASBTC_poloniex.getBid();
                            cd3a = GASBTC_poloniex.getAsk();

                        }


                        if (c3.equalsIgnoreCase("XCPBTC_poloniex")) {

                            cd3b = XCPBTC_poloniex.getBid();
                            cd3a = XCPBTC_poloniex.getAsk();

                        }


                        if (c3.equalsIgnoreCase("GNTBTC_poloniex")) {

                            cd3b = GNTBTC_poloniex.getBid();
                            cd3a = GNTBTC_poloniex.getAsk();

                        }

                        if (c3.equalsIgnoreCase("ARRBTC_poloniex")) {

                            cd3b = ARRBTC_poloniex.getBid();
                            cd3a = ARRBTC_poloniex.getAsk();

                        }

                        if (c3.equalsIgnoreCase("GMEBTC_poloniex")) {

                            cd3b = GMEBTC_poloniex.getBid();
                            cd3a = GMEBTC_poloniex.getAsk();

                        }


                        if (c3.equalsIgnoreCase("REPBTC_poloniex")) {

                            cd3b = REPBTC_poloniex.getBid();
                            cd3a = REPBTC_poloniex.getAsk();

                        }


                        if (c3.equalsIgnoreCase("OMGBTC_poloniex")) {

                            cd3b = OMGBTC_poloniex.getBid();
                            cd3a = OMGBTC_poloniex.getAsk();

                        }


                        if (c3.equalsIgnoreCase("BTSBTC_poloniex")) {

                            cd3b = BTSBTC_poloniex.getBid();
                            cd3a = BTSBTC_poloniex.getAsk();

                        }

                        if (c3.equalsIgnoreCase("LSKBTC_poloniex")) {

                            cd3b = LSKBTC_poloniex.getBid();
                            cd3a = LSKBTC_poloniex.getAsk();

                        }

                        if (c3.equalsIgnoreCase("GRCBTC_poloniex")) {

                            cd3b = GRCBTC_poloniex.getBid();
                            cd3a = GRCBTC_poloniex.getAsk();

                        }

                        if (c3.equalsIgnoreCase("STMETH_poloniex")) {

                            cd3b = STMETH_poloniex.getBid();
                            cd3a = STMETH_poloniex.getAsk();

                        }

                        if (c3.equalsIgnoreCase("XLMBTC_poloniex")) {

                            cd3b = XLMBTC_poloniex.getBid();
                            cd3a = XLMBTC_poloniex.getAsk();

                        }

                        if (c3.equalsIgnoreCase("NXTXMR_poloniex")) {

                            cd3b = NXTXMR_poloniex.getBid();
                            cd3a = NXTXMR_poloniex.getAsk();

                        }


                        if (c3.equalsIgnoreCase("DSHXMR_poloniex")) {

                            cd3b = DSHXMR_poloniex.getBid();
                            cd3a = DSHXMR_poloniex.getAsk();

                        }

                        if (c3.equalsIgnoreCase("ZECETH_poloniex")) {

                            cd3b = ZECETH_poloniex.getBid();
                            cd3a = ZECETH_poloniex.getAsk();

                        }


                        if (c3.equalsIgnoreCase("ETCETH_poloniex")) {

                            cd3b = ETCETH_poloniex.getBid();
                            cd3a = ETCETH_poloniex.getAsk();

                        }


                        if (c3.equalsIgnoreCase("BTMBTC_poloniex")) {

                            cd3b = BTMBTC_poloniex.getBid();
                            cd3a = BTMBTC_poloniex.getAsk();

                        }

                        if (c3.equalsIgnoreCase("NESBTC_poloniex")) {

                            cd3b = NESBTC_poloniex.getBid();
                            cd3a = NESBTC_poloniex.getAsk();

                        }

                        if (c3.equalsIgnoreCase("BTDBTC_poloniex")) {

                            cd3b = BTDBTC_poloniex.getBid();
                            cd3a = BTDBTC_poloniex.getAsk();

                        }


                        if (c3.equalsIgnoreCase("XBCBTC_poloniex")) {

                            cd3b = XBCBTC_poloniex.getBid();
                            cd3a = XBCBTC_poloniex.getAsk();

                        }

                        if (c3.equalsIgnoreCase("XPMBTC_poloniex")) {

                            cd3b = XPMBTC_poloniex.getBid();
                            cd3a = XPMBTC_poloniex.getAsk();

                        }

                        if (c3.equalsIgnoreCase("VIABTC_poloniex")) {

                            cd3b = VIABTC_poloniex.getBid();
                            cd3a = VIABTC_poloniex.getAsk();

                        }

                        if (c3.equalsIgnoreCase("NAVBTC_poloniex")) {

                            cd3b = NAVBTC_poloniex.getBid();
                            cd3a = NAVBTC_poloniex.getAsk();

                        }


                        if (c3.equalsIgnoreCase("PNKBTC_poloniex")) {

                            cd3b = PNKBTC_poloniex.getBid();
                            cd3a = PNKBTC_poloniex.getAsk();

                        }

                        if (c3.equalsIgnoreCase("OMNBTC_poloniex")) {

                            cd3b = OMNBTC_poloniex.getBid();
                            cd3a = OMNBTC_poloniex.getAsk();

                        }

                        if (c3.equalsIgnoreCase("FLOBTC_poloniex")) {

                            cd3b = FLOBTC_poloniex.getBid();
                            cd3a = FLOBTC_poloniex.getAsk();

                        }

                        if (c3.equalsIgnoreCase("NMCBTC_poloniex")) {

                            cd3b = NMCBTC_poloniex.getBid();
                            cd3a = NMCBTC_poloniex.getAsk();

                        }


                        if (c3.equalsIgnoreCase("VRCBTC_poloniex")) {

                            cd3b = VRCBTC_poloniex.getBid();
                            cd3a = VRCBTC_poloniex.getAsk();

                        }

                        if (c3.equalsIgnoreCase("LBCBTC_poloniex")) {

                            cd3b = LBCBTC_poloniex.getBid();
                            cd3a = LBCBTC_poloniex.getAsk();

                        }

                        if (c3.equalsIgnoreCase("EMCBTC_poloniex")) {

                            cd3b = EMCBTC_poloniex.getBid();
                            cd3a = EMCBTC_poloniex.getAsk();

                        }

                        if (c3.equalsIgnoreCase("LTCBTC_poloniex")) {

                            cd3b = LTCBTC_poloniex.getBid();
                            cd3a = LTCBTC_poloniex.getAsk();

                        }

                        if (c3.equalsIgnoreCase("ZRXBTC_poloniex")) {

                            cd3b = ZRXBTC_poloniex.getBid();
                            cd3a = ZRXBTC_poloniex.getAsk();

                        }


                        if (c3.equalsIgnoreCase("MADBTC_poloniex")) {

                            cd3b = MADBTC_poloniex.getBid();
                            cd3a = MADBTC_poloniex.getAsk();

                        }


                        if (c3.equalsIgnoreCase("CVCETH_poloniex")) {

                            cd3b = CVCETH_poloniex.getBid();
                            cd3a = CVCETH_poloniex.getAsk();

                        }


                        if (c3.equalsIgnoreCase("LTCXMR_poloniex")) {

                            cd3b = LTCXMR_poloniex.getBid();
                            cd3a = LTCXMR_poloniex.getAsk();

                        }


                        if (c3.equalsIgnoreCase("OMGETH_poloniex")) {

                            cd3b = OMGETH_poloniex.getBid();
                            cd3a = OMGETH_poloniex.getAsk();

                        }


                        if (c3.equalsIgnoreCase("LSKETH_poloniex")) {

                            cd3b = LSKETH_poloniex.getBid();
                            cd3a = LSKETH_poloniex.getAsk();

                        }

                        if (c3.equalsIgnoreCase("BCHETH_poloniex")) {

                            cd3b = BCHETH_poloniex.getBid();
                            cd3a = BCHETH_poloniex.getAsk();

                        }

                        if (c3.equalsIgnoreCase("ZRXETH_poloniex")) {

                            cd3b = ZRXETH_poloniex.getBid();
                            cd3a = ZRXETH_poloniex.getAsk();

                        }


                        if (c3.equalsIgnoreCase("ZECBTC_poloniex")) {

                            cd3b = ZECBTC_poloniex.getBid();
                            cd3a = ZECBTC_poloniex.getAsk();

                        }

                        if (c3.equalsIgnoreCase("CLMBTC_poloniex")) {

                            cd3b = CLMBTC_poloniex.getBid();
                            cd3a = CLMBTC_poloniex.getAsk();

                        }

                        if (c3.equalsIgnoreCase("VCHBTC_poloniex")) {

                            cd3b = VCHBTC_poloniex.getBid();
                            cd3a = VCHBTC_poloniex.getAsk();

                        }

                        if (c3.equalsIgnoreCase("CVCBTC_poloniex")) {

                            cd3b = CVCBTC_poloniex.getBid();
                            cd3a = CVCBTC_poloniex.getAsk();

                        }

                        if (c3.equalsIgnoreCase("BRSBTC_poloniex")) {

                            cd3b = BRSBTC_poloniex.getBid();
                            cd3a = BRSBTC_poloniex.getAsk();

                        }


                        if (c3.equalsIgnoreCase("DCRBTC_poloniex")) {

                            cd3b = DCRBTC_poloniex.getBid();
                            cd3a = DCRBTC_poloniex.getAsk();

                        }

                        if (c3.equalsIgnoreCase("EXPBTC_poloniex")) {

                            cd3b = EXPBTC_poloniex.getBid();
                            cd3a = EXPBTC_poloniex.getAsk();

                        }

                        if (c3.equalsIgnoreCase("REPETH_poloniex")) {

                            cd3b = REPETH_poloniex.getBid();
                            cd3a = REPETH_poloniex.getAsk();

                        }

                        if (c3.equalsIgnoreCase("GASETH_poloniex")) {

                            cd3b = GASETH_poloniex.getBid();
                            cd3a = GASETH_poloniex.getAsk();

                        }


                        if (c3.equalsIgnoreCase("PASBTC_poloniex")) {

                            cd3b = PASBTC_poloniex.getBid();
                            cd3a = PASBTC_poloniex.getAsk();

                        }

                        if (c3.equalsIgnoreCase("NMEBTC_poloniex")) {

                            cd3b = NMEBTC_poloniex.getBid();
                            cd3a = NMEBTC_poloniex.getAsk();

                        }


                        if (c3.equalsIgnoreCase("SCXBTC_poloniex")) {

                            cd3b = SCXBTC_poloniex.getBid();
                            cd3a = SCXBTC_poloniex.getAsk();

                        }

                        if (c3.equalsIgnoreCase("STMBTC_poloniex")) {

                            cd3b = STMBTC_poloniex.getBid();
                            cd3a = STMBTC_poloniex.getAsk();

                        }

                        if (c3.equalsIgnoreCase("STTBTC_poloniex")) {

                            cd3b = STTBTC_poloniex.getBid();
                            cd3a = STTBTC_poloniex.getAsk();

                        }


                        if (c3.equalsIgnoreCase("BCHBTC_poloniex")) {

                            cd3b = BCHBTC_poloniex.getBid();
                            cd3a = BCHBTC_poloniex.getAsk();

                        }


                        if (c3.equalsIgnoreCase("XEMBTC_poloniex")) {

                            cd3b = XEMBTC_poloniex.getBid();
                            cd3a = XEMBTC_poloniex.getAsk();

                        }


                        if (c3.equalsIgnoreCase("DSHBTC_poloniex")) {

                            cd3b = DSHBTC_poloniex.getBid();
                            cd3a = DSHBTC_poloniex.getAsk();

                        }

                        if (c3.equalsIgnoreCase("ETCBTC_poloniex")) {

                            cd3b = ETCBTC_poloniex.getBid();
                            cd3a = ETCBTC_poloniex.getAsk();

                        }


                        if (c3.equalsIgnoreCase("ETHBTC_kraken")) {

                            cd3b = ETHBTC_kraken.getBid();
                            cd3a = ETHBTC_kraken.getAsk();

                        }

                        if (c3.equalsIgnoreCase("ETHBTC_gdax")) {

                            cd3b = ETHBTC_gdax.getBid();
                            cd3a = ETHBTC_gdax.getAsk();

                        }


                        if (c3.equalsIgnoreCase("BCHBTC_kraken")) {

                            cd3b = BCHBTC_kraken.getBid();
                            cd3a = BCHBTC_kraken.getAsk();

                        }


                        if (c3.equalsIgnoreCase("XLMBTC_kraken")) {

                            cd3b = XLMBTC_kraken.getBid();
                            cd3a = XLMBTC_kraken.getAsk();

                        }

                        if (c3.equalsIgnoreCase("REPBTC_kraken")) {

                            cd3b = REPBTC_kraken.getBid();
                            cd3a = REPBTC_kraken.getAsk();

                        }


                        if (c3.equalsIgnoreCase("ETHBTC_gemini")) {

                            cd3b = ETHBTC_gemini.getBid();
                            cd3a = ETHBTC_gemini.getAsk();

                        }


                        if (c3.equalsIgnoreCase("ETCBTC_kraken")) {

                            cd3b = ETCBTC_kraken.getBid();
                            cd3a = ETCBTC_kraken.getAsk();

                        }


                        if (c3.equalsIgnoreCase("ETHBTC_gdax")) {

                            cd3b = ETHBTC_gdax.getBid();
                            cd3a = ETHBTC_gdax.getAsk();

                        }


                        if (c3.equalsIgnoreCase("LTCBTC_gdax")) {

                            cd3b = LTCBTC_gdax.getBid();
                            cd3a = LTCBTC_gdax.getAsk();

                        }


                        if (c3.equalsIgnoreCase("DSHBTC_kraken")) {

                            cd3b = DSHBTC_kraken.getBid();
                            cd3a = DSHBTC_kraken.getAsk();

                        }


                        if (c3.equalsIgnoreCase("MLNBTC_kraken")) {

                            cd3b = MLNBTC_kraken.getBid();
                            cd3a = MLNBTC_kraken.getAsk();

                        }


                        if (c3.equalsIgnoreCase("GNOBTC_kraken")) {

                            cd3b = GNOBTC_kraken.getBid();
                            cd3a = GNOBTC_kraken.getAsk();

                        }

                        if (c3.equalsIgnoreCase("ICNETH_kraken")) {

                            cd3b = ICNETH_kraken.getBid();
                            cd3a = ICNETH_kraken.getAsk();

                        }


                        if (c3.equalsIgnoreCase("ETCETH_kraken")) {

                            cd3b = ETCETH_kraken.getBid();
                            cd3a = ETCETH_kraken.getAsk();

                        }


                        if (c3.equalsIgnoreCase("ZECBTC_kraken")) {

                            cd3b = ZECBTC_kraken.getBid();
                            cd3a = ZECBTC_kraken.getAsk();

                        }


                        if (c3.equalsIgnoreCase("ICNBTC_kraken")) {

                            cd3b = ICNBTC_kraken.getBid();
                            cd3a = ICNBTC_kraken.getAsk();

                        }

                        if (c3.equalsIgnoreCase("EOSETH_kraken")) {

                            cd3b = EOSETH_kraken.getBid();
                            cd3a = EOSETH_kraken.getAsk();

                        }


                        if (c3.equalsIgnoreCase("GNOETH_kraken")) {

                            cd3b = GNOETH_kraken.getBid();
                            cd3a = GNOETH_kraken.getAsk();

                        }

                        if (c3.equalsIgnoreCase("LTCBTC_kraken")) {

                            cd3b = LTCBTC_kraken.getBid();
                            cd3a = LTCBTC_kraken.getAsk();

                        }

                        if (c3.equalsIgnoreCase("ETHEOS_kraken")) {

                            cd3b = ETHEOS_kraken.getBid();
                            cd3a = ETHEOS_kraken.getAsk();

                        }


                        if (c3.equalsIgnoreCase("XRPBTC_poloniex")) {

                            cd3b = XRPBTC_poloniex.getBid();
                            cd3a = XRPBTC_poloniex.getAsk();

                        }

                        if (c3.equalsIgnoreCase("XRPBTC_binance")) {

                            cd3b = XRPBTC_binance.getBid();
                            cd3a = XRPBTC_binance.getAsk();

                        }

                        if (c3.equalsIgnoreCase("XRPBTC_kraken")) {

                            cd3b = XRPBTC_kraken.getBid();
                            cd3a = XRPBTC_kraken.getAsk();

                        }


                        if (c3.equalsIgnoreCase("XRPETH_binance")) {

                            cd3b = XRPETH_binance.getBid();
                            cd3a = XRPETH_binance.getAsk();

                        }


                        if (c3.equalsIgnoreCase("XMRBTC_poloniex")) {

                            cd3b = XMRBTC_poloniex.getBid();
                            cd3a = XMRBTC_poloniex.getAsk();

                        }

                        if (c3.equalsIgnoreCase("XMRBTC_binance")) {

                            cd3b = XMRBTC_binance.getBid();
                            cd3a = XMRBTC_binance.getAsk();

                        }

                        if (c3.equalsIgnoreCase("XMRBTC_kraken")) {

                            cd3b = XMRBTC_kraken.getBid();
                            cd3a = XMRBTC_kraken.getAsk();

                        }

                        if (c3.equalsIgnoreCase("XMRETH_binance")) {

                            cd3b = XMRETH_binance.getBid();
                            cd3a = XMRETH_binance.getAsk();


                            // Calculate triangular arbitrage

                            if (  // Path 1
                                    (c1.substring(3, 6).equals(c2.substring(0, 3)) && c2.substring(3, 6).equals(c3.substring(0, 3)))
                                            && (c1.substring(0, 3).equals(c3.substring(3, 6)))) {

                                triArbitrage[z] = 100 * ((cd1b.doubleValue()) * (cd2b.doubleValue()) * (cd3b.doubleValue())) - 100;
                                path = 1;

                            }

                            if (   // Path 2
                                    (c1.substring(3, 6).equals(c2.substring(0, 3)) && c2.substring(3, 6).equals(c3.substring(3, 6)))
                                            && (c1.substring(0, 3).equals(c3.substring(0, 3)))) {

                                triArbitrage[z] = 100 * ((cd1b.doubleValue()) * (cd2b.doubleValue()) * (1 / cd3a.doubleValue())) - 100;
                                path = 2;

                            }

                            if (   // Path 3
                                    (c1.substring(3, 6).equals(c2.substring(3, 6)) && c2.substring(0, 3).equals(c3.substring(0, 3)))
                                            && (c1.substring(0, 3).equals(c3.substring(3, 6)))) {

                                triArbitrage[z] = 100 * ((cd1b.doubleValue()) * (1 / cd2a.doubleValue()) * (cd3b.doubleValue())) - 100;
                                path = 3;

                            }

                            if (// Path 4
                                    (c1.substring(3, 6).equals(c2.substring(3, 6)) && c2.substring(0, 3).equals(c3.substring(3, 6)))
                                            && (c1.substring(0, 3).equals(c3.substring(0, 3)))) {

                                triArbitrage[z] = 100 * ((cd1b.doubleValue()) * (1 / cd2a.doubleValue()) * (1 / cd3a.doubleValue())) - 100;
                                path = 4;

                            }

                            if (   // Path 5
                                    (c1.substring(0, 3).equals(c2.substring(0, 3)) && c2.substring(3, 6).equals(c3.substring(0, 3)))
                                            && (c1.substring(3, 6).equals(c3.substring(3, 6)))) {

                                triArbitrage[z] = 100 * ((1 / cd1a.doubleValue()) * (cd2b.doubleValue()) * (cd3b.doubleValue())) - 100;
                                path = 5;

                            }

                            if (   // Path 6
                                    (c1.substring(0, 3).equals(c2.substring(0, 3)) && c2.substring(3, 6).equals(c3.substring(3, 6)))
                                            && (c1.substring(3, 6).equals(c3.substring(0, 3)))) {

                                triArbitrage[z] = 100 * ((1 / cd1a.doubleValue()) * (cd2b.doubleValue()) * (1 / cd3a.doubleValue())) - 100;
                                path = 6;

                            }

                            if (   // Path 7
                                    (c1.substring(0, 3).equals(c2.substring(3, 6)) && c2.substring(0, 3).equals(c3.substring(0, 3)))
                                            && (c1.substring(3, 6).equals(c3.substring(3, 6)))) {

                                triArbitrage[z] = 100 * ((1 / cd1a.doubleValue()) * (1 / cd2a.doubleValue()) * (cd3b.doubleValue())) - 100;
                                path = 7;

                            }

                            if (   // Path 8
                                    (c1.substring(0, 3).equals(c2.substring(3, 6)) && c2.substring(0, 3).equals(c3.substring(3, 6)))
                                            && (c1.substring(3, 6).equals(c3.substring(0, 3)))) {

                                triArbitrage[z] = 100 * ((1 / cd1a.doubleValue()) * (1 / cd2a.doubleValue()) * (1 / cd3a.doubleValue())) - 100;
                                path = 8;

                            }

                            //If triangular arbitrage profit is over SPECIFIED% display
                            if (triArbitrage[z] >= profitTarget) {

                                optimalPathText.append("#" + z + ": " +

                                        ((path == 1) ? " SELL " + c1 + " " + " SELL " + c2 + " " + " SELL " + c3 : "") +
                                        ((path == 2) ? " SELL " + c1 + " " + " SELL " + c2 + " " + " BUY " + c3 : "") +
                                        ((path == 3) ? " SELL " + c1 + " " + " BUY " + c2 + " " + " SELL " + c3 : "") +
                                        ((path == 4) ? " SELL " + c1 + " " + " BUY " + c2 + " " + " BUY " + c3 : "") +
                                        ((path == 5) ? " BUY " + c1 + " " + " SELL " + c2 + " " + " SELL " + c3 : "") +
                                        ((path == 6) ? " BUY " + c1 + " " + " SELL " + c2 + " " + " BUY " + c3 : "") +
                                        ((path == 7) ? " BUY " + c1 + " " + " BUY " + c2 + " " + " SELL " + c3 : "") +
                                        ((path == 8) ? " BUY " + c1 + " " + " BUY " + c2 + " " + " BUY " + c3 : "") +

                                        " \n" +

                                        "Bid/Ask: " + cd1b + "/" + cd1a + "\nBid/Ask: " + cd2b + "/" + cd2a + "\nBid/Ask: " + cd3b +
                                        "/" + cd3a + "\n+$" + triArbitrage[z] + "\n\n");


                                System.out.println(optimalPathText.toString());


                            }

                        }

                    }

                }

            }

        } // End of triangularArbitrage() method

    } // End of Class


}