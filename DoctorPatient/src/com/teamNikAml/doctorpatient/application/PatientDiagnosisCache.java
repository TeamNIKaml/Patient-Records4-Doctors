package com.teamNikAml.doctorpatient.application;

public class PatientDiagnosisCache {

	String ccProcess, ccNote, hpiProcess, hpiNote, cmProcess, cmNote;
	String peProcess, peNote, seProcess, seNote, ddProcess, ddNote;
	String pdProcess, pdNote, lrPocess, lrNote, csProcess, csNote;
	int patientId;
	long statusFlagcc, statusFlaghpi, statusFlagcm, statusFlagpe, statusFlagse, statusFlagdd, statusFlagpd, statusFlaglr, statusFlagcs;	
	
	public PatientDiagnosisCache() {
		super();
		this.ccProcess = "";
		this.ccNote = "";
		this.hpiProcess = "";
		this.hpiNote = "";
		this.cmProcess = "";
		this.cmNote = "";
		this.peProcess = "";
		this.peNote = "";
		this.seProcess = "";
		this.seNote = "";
		this.ddProcess = "";
		this.ddNote = "";
		this.pdProcess = "";
		this.pdNote = "";
		this.lrPocess = "";
		this.lrNote = "";
		this.csProcess = "";
		this.csNote = "";
		this.patientId = 0;
		this.statusFlagcc = 0;
		this.statusFlaghpi = 0;
		this.statusFlagcm = 0;
		this.statusFlagpe = 0;
		this.statusFlagse = 0;
		this.statusFlagdd = 0;
		this.statusFlagpd = 0;
		this.statusFlaglr = 0;
		this.statusFlagcs = 0;
	}

	/*********************************************/
	
	public long getStatusFlagcm() {
		return statusFlagcm;
	}
	public void setStatusFlagcm(long statusFlagcm) {
		this.statusFlagcm = statusFlagcm;
	}
	public long getStatusFlagpe() {
		return statusFlagpe;
	}
	public void setStatusFlagpe(long statusFlagpe) {
		this.statusFlagpe = statusFlagpe;
	}
	public long getStatusFlagse() {
		return statusFlagse;
	}
	public void setStatusFlagse(long statusFlagse) {
		this.statusFlagse = statusFlagse;
	}
	public long getStatusFlagdd() {
		return statusFlagdd;
	}
	public void setStatusFlagdd(long statusFlagdd) {
		this.statusFlagdd = statusFlagdd;
	}
	public long getStatusFlagpd() {
		return statusFlagpd;
	}
	public void setStatusFlagpd(long statusFlagpd) {
		this.statusFlagpd = statusFlagpd;
	}
	public long getStatusFlaglr() {
		return statusFlaglr;
	}
	public void setStatusFlaglr(long statusFlaglr) {
		this.statusFlaglr = statusFlaglr;
	}
	public long getStatusFlagcs() {
		return statusFlagcs;
	}
	public void setStatusFlagcs(long statusFlagcs) {
		this.statusFlagcs = statusFlagcs;
	}
	public long getStatusFlaghpi() {
		return statusFlaghpi;
	}
	public void setStatusFlaghpi(long statusFlaghpi) {
		this.statusFlaghpi = statusFlaghpi;
	}
	public long getStatusFlagcc() {
		return statusFlagcc;
	}

	public void setStatusFlagcc(long statusFlag) {
		this.statusFlagcc = statusFlag;
	}
	
	/********************************************************************/
	
	public int getPatientId() {
		return patientId;
	}
	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}
	
	/******************************************************************/
	
	public String getCcProcess() {
		return ccProcess;
	}
	public void setCcProcess(String ccProcess) {
		this.ccProcess = ccProcess;
	}
	public String getCcNote() {
		return ccNote;
	}
	public void setCcNote(String ccNote) {
		this.ccNote = ccNote;
	}
	public String getHpiProcess() {
		return hpiProcess;
	}
	public void setHpiProcess(String hpiProcess) {
		this.hpiProcess = hpiProcess;
	}
	public String getHpiNote() {
		return hpiNote;
	}
	public void setHpiNote(String hpiNote) {
		this.hpiNote = hpiNote;
	}
	public String getCmProcess() {
		return cmProcess;
	}
	public void setCmProcess(String cmProcess) {
		this.cmProcess = cmProcess;
	}
	public String getCmNote() {
		return cmNote;
	}
	public void setCmNote(String cmNote) {
		this.cmNote = cmNote;
	}
	public String getPeProcess() {
		return peProcess;
	}
	public void setPeProcess(String peProcess) {
		this.peProcess = peProcess;
	}
	public String getPeNote() {
		return peNote;
	}
	public void setPeNote(String peNote) {
		this.peNote = peNote;
	}
	public String getSeProcess() {
		return seProcess;
	}
	public void setSeProcess(String seProcess) {
		this.seProcess = seProcess;
	}
	public String getSeNote() {
		return seNote;
	}
	public void setSeNote(String seNote) {
		this.seNote = seNote;
	}
	public String getDdProcess() {
		return ddProcess;
	}
	public void setDdProcess(String ddProcess) {
		this.ddProcess = ddProcess;
	}
	public String getDdNote() {
		return ddNote;
	}
	public void setDdNote(String ddNote) {
		this.ddNote = ddNote;
	}
	public String getPdProcess() {
		return pdProcess;
	}
	public void setPdProcess(String pdProcess) {
		this.pdProcess = pdProcess;
	}
	public String getPdNote() {
		return pdNote;
	}
	public void setPdNote(String pdNote) {
		this.pdNote = pdNote;
	}
	public String getLrPocess() {
		return lrPocess;
	}
	public void setLrPocess(String lrPocess) {
		this.lrPocess = lrPocess;
	}
	public String getLrNote() {
		return lrNote;
	}
	public void setLrNote(String lrNote) {
		this.lrNote = lrNote;
	}
	public String getCsProcess() {
		return csProcess;
	}
	public void setCsProcess(String csProcess) {
		this.csProcess = csProcess;
	}
	public String getCsNote() {
		return csNote;
	}
	public void setCsNote(String csNote) {
		this.csNote = csNote;
	}
	
	/*********************************************************/
	
	public void reSetPatientCache(){
		this.ccProcess = "";
		this.ccNote = "";
		this.hpiProcess = "";
		this.hpiNote = "";
		this.cmProcess = "";
		this.cmNote = "";
		this.peProcess = "";
		this.peNote = "";
		this.seProcess = "";
		this.seNote = "";
		this.ddProcess = "";
		this.ddNote = "";
		this.pdProcess = "";
		this.pdNote = "";
		this.lrPocess = "";
		this.lrNote = "";
		this.csProcess = "";
		this.csNote = "";
		this.patientId = 0;
		this.statusFlagcc = 0;
		this.statusFlaghpi = 0;
		this.statusFlagcm = 0;
		this.statusFlagpe = 0;
		this.statusFlagse = 0;
		this.statusFlagdd = 0;
		this.statusFlagpd = 0;
		this.statusFlaglr = 0;
		this.statusFlagcs = 0;
	}
	
}
