package net.authorize.acceptsdk.datamodel.merchant;

import junit.framework.Assert;
import net.authorize.acceptsdk.exception.AcceptSDKException;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * Created by Kiran Bollepalli on 14,July,2016.
 * kbollepa@visa.com
 */
public class ClientKeyBasedMerchantAuthenticationTest {

  private String mClientKey;
  private String mApiLoginId;

  @Before public void setUp()  {
    mApiLoginId = "6AB64hcB";
    mClientKey = "6gSuV295YD86Mq4d86zEsx8C839uMVVjfXm9N4wr6DRuhTHpDU97NFyKtfZncUq8";
  }

  @Rule public ExpectedException expectedException = ExpectedException.none();

  @Test public void testCreateMerchantAuthentication() throws AcceptSDKException {
    ClientKeyBasedMerchantAuthentication merchantAuthentication =
        ClientKeyBasedMerchantAuthentication.createMerchantAuthentication(mApiLoginId, mClientKey);
    Assert.assertNotNull(merchantAuthentication);
  }

  @Test public void testApiLoginIDForNull() throws AcceptSDKException {
    mApiLoginId = null;
    mClientKey = "6gSuV295YD86Mq4d86zEsx8C839uMVVjfXm9N4wr6DRuhTHpDU97NFyKtfZncUq8";
    expectedException.expect(AcceptSDKException.class);
    expectedException.expectMessage(AcceptSDKException.APIKEY_ERROR);
    ClientKeyBasedMerchantAuthentication merchantAuthentication =
        ClientKeyBasedMerchantAuthentication.createMerchantAuthentication(mApiLoginId, mClientKey);
  }

  @Test public void testApiLoginIDForException() throws AcceptSDKException {
    mApiLoginId = "";
    mClientKey = "6gSuV295YD86Mq4d86zEsx8C839uMVVjfXm9N4wr6DRuhTHpDU97NFyKtfZncUq8";
    expectedException.expect(AcceptSDKException.class);
    expectedException.expectMessage(AcceptSDKException.APIKEY_ERROR);
    ClientKeyBasedMerchantAuthentication merchantAuthentication =
        ClientKeyBasedMerchantAuthentication.createMerchantAuthentication(mApiLoginId, mClientKey);
  }

  @Test public void testClientKeyForException() throws AcceptSDKException {
    mApiLoginId = "6AB64hcB";
    mClientKey = "";
    expectedException.expect(AcceptSDKException.class);
    expectedException.expectMessage(AcceptSDKException.CLIENTKEY_ERROR);
    ClientKeyBasedMerchantAuthentication merchantAuthentication =
        ClientKeyBasedMerchantAuthentication.createMerchantAuthentication(mApiLoginId, mClientKey);
  }

  @Test public void testClientKeyForNull() throws AcceptSDKException {
    mApiLoginId = "6AB64hcB";
    mClientKey =null;
    expectedException.expect(AcceptSDKException.class);
    expectedException.expectMessage(AcceptSDKException.CLIENTKEY_ERROR);
    ClientKeyBasedMerchantAuthentication merchantAuthentication =
        ClientKeyBasedMerchantAuthentication.createMerchantAuthentication(mApiLoginId, mClientKey);
  }
}