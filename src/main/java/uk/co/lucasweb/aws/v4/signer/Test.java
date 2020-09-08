/*
 * Copyright 2020 mreddy.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package uk.co.lucasweb.aws.v4.signer;

import java.net.URI;
import uk.co.lucasweb.aws.v4.signer.credentials.AwsCredentials;

/**
 *
 * @author mreddy
 */
public class Test {

    public static void main(String args[]) {
        try {
            String contentSha256 = "e3b0c44298fc1c149afbf4c8996fb92427ae41e4649b934ca495991b7852b855";
            HttpRequest request = new HttpRequest("GET", new URI("https://s3.amazonaws.com/TestZe/Thor2.csv"));
            String signature = Signer.builder()
                    .awsCredentials(new AwsCredentials("xx", "xx"))
                    .header("Host", "TestZe.s3.amazonaws.com")
                    .header("x-amz-date", "20200908T000000Z")
                    .header("x-amz-content-sha256", contentSha256)
                    .buildS3(request, contentSha256)
                    .getSignature();
            System.out.println("signature: "+signature);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
