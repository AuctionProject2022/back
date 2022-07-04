package kr.toyauction.domain.file.handler;

import kr.toyauction.domain.file.event.FileUploadEvent;
import kr.toyauction.domain.file.exception.FileUploadFailedException;
import kr.toyauction.intra.aws.client.IntraAwsS3Client;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;
import org.springframework.validation.annotation.Validated;
import software.amazon.awssdk.services.s3.model.S3Exception;

@Slf4j
@Component
@RequiredArgsConstructor
public class FileEventHandler {

	private final IntraAwsS3Client intraAwsS3Client;

	@Async
	@TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT)
	public void publishEventListener(@Validated final FileUploadEvent event) {
		try {
			intraAwsS3Client.upload(event.getFile(), event.getKey());
		} catch (S3Exception e) {
			log.error("S3Exception", e);
			throw new FileUploadFailedException();
		}
	}
}
