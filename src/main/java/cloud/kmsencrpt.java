package aws.example.kms;


import com.amazonaws.services.kms.AWSKMS;
import com.amazonaws.services.kms.AWSKMSClientBuilder;
import com.amazonaws.services.kms.model.EncryptRequest;

import java.nio.ByteBuffer;

public class EncryptDataKey {
    public static void main(String[] args) {
        AWSKMS kmsClient = AWSKMSClientBuilder.standard().build();

        // Encrypt a data key
        //
        // Replace the following fictitious CMK ARN with a valid CMK ID or ARN
<<<<<<< HEAD
        String keyId = "1234abcd-12ab-34cd-56ef-1234567890ab";
=======
        String keyId = "{my_key_from_real}";
>>>>>>> 61a5ea9667415cc8ba3e6591fbbbc1493e1d960d
        ByteBuffer plaintext = ByteBuffer.wrap(new byte[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0});

        EncryptRequest req = new EncryptRequest().withKeyId(keyId).withPlaintext(plaintext);
        ByteBuffer ciphertext = kmsClient.encrypt(req).getCiphertextBlob();
    }
<<<<<<< HEAD
}
=======
}
>>>>>>> 61a5ea9667415cc8ba3e6591fbbbc1493e1d960d
