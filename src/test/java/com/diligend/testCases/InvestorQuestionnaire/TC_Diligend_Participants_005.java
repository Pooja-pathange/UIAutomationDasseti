
package com.diligend.testCases.InvestorQuestionnaire;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.diligend.BaseClass.DiligendBaseClass;
import com.diligend.PageObjects.Questionnaires.DiligendParticpantPages;

public class TC_Diligend_Participants_005 extends DiligendBaseClass {

	DiligendParticpantPages objPP = new DiligendParticpantPages(driver);

	public void Particpants_Page() {

		try {
			logger.info("Test Participants page started");

			objPP.ParticipantsFromSidebar();
			Thread.sleep(300);
			Assert.assertTrue(true);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			logger.warn(e);
			Assert.assertTrue(false);
			logger.warn("Test Participants page  failed");

		}

	}

	@Test(dataProvider = "Particpants_Page")
	public void AddParticipantsPage() {
		try {
			logger.info("Test Add Particpants by company name started");
			objPP.AddParticipantsMethod();
			Thread.sleep(300);
			Assert.assertTrue(true);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			logger.warn(e);
			Assert.assertTrue(false);
			logger.warn("Test Add Particpants by company name failed");
		}
	}

	@Test(dataProvider = "AddParticipantsPage")
	public void InviteParticpants_Page() {
		try {
			logger.info("Test Invite Particpants started");
			objPP.inviteParticipantMethod();
			Assert.assertTrue(true);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			logger.warn(e);
			Assert.assertTrue(false);
			logger.warn("Test Invite Particpants failed");
		}

	}
}