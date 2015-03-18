package com.teamNikAml.doctorpatient.application;

public class PatientDiagnosisCache {

	StringBuilder ccProcess, ccNote, hpiProcess, hpiNote, cmProcess, cmNote;
	StringBuilder peProcess, peNote, seProcess, seNote, ddProcess, ddNote;
	StringBuilder pdProcess, pdNote, lrrocess, lrNote, csProcess, csNote;
	int patientId;
	
	
	
	
	public PatientDiagnosisCache() {
		super();
		this.ccProcess = null;
		this.ccNote = null;
		this.hpiProcess = null;
		this.hpiNote = null;
		this.cmProcess = null;
		this.cmNote = null;
		this.peProcess = null;
		this.peNote = null;
		this.seProcess = null;
		this.seNote = null;
		this.ddProcess = null;
		this.ddNote = null;
		this.pdProcess = null;
		this.pdNote = null;
		this.lrrocess = null;
		this.lrNote = null;
		this.csProcess = null;
		this.csNote = null;
		this.patientId = 0;
	}
	public int getPatientId() {
		return patientId;
	}
	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}
	public StringBuilder getCcProcess() {
		return ccProcess;
	}
	public void setCcProcess(StringBuilder ccProcess) {
		this.ccProcess = ccProcess;
	}
	public StringBuilder getCcNote() {
		return ccNote;
	}
	public void setCcNote(StringBuilder ccNote) {
		this.ccNote = ccNote;
	}
	public StringBuilder getHpiProcess() {
		return hpiProcess;
	}
	public void setHpiProcess(StringBuilder hpiProcess) {
		this.hpiProcess = hpiProcess;
	}
	public StringBuilder getHpiNote() {
		return hpiNote;
	}
	public void setHpiNote(StringBuilder hpiNote) {
		this.hpiNote = hpiNote;
	}
	public StringBuilder getCmProcess() {
		return cmProcess;
	}
	public void setCmProcess(StringBuilder cmProcess) {
		this.cmProcess = cmProcess;
	}
	public StringBuilder getCmNote() {
		return cmNote;
	}
	public void setCmNote(StringBuilder cmNote) {
		this.cmNote = cmNote;
	}
	public StringBuilder getPeProcess() {
		return peProcess;
	}
	public void setPeProcess(StringBuilder peProcess) {
		this.peProcess = peProcess;
	}
	public StringBuilder getPeNote() {
		return peNote;
	}
	public void setPeNote(StringBuilder peNote) {
		this.peNote = peNote;
	}
	public StringBuilder getSeProcess() {
		return seProcess;
	}
	public void setSeProcess(StringBuilder seProcess) {
		this.seProcess = seProcess;
	}
	public StringBuilder getSeNote() {
		return seNote;
	}
	public void setSeNote(StringBuilder seNote) {
		this.seNote = seNote;
	}
	public StringBuilder getDdProcess() {
		return ddProcess;
	}
	public void setDdProcess(StringBuilder ddProcess) {
		this.ddProcess = ddProcess;
	}
	public StringBuilder getDdNote() {
		return ddNote;
	}
	public void setDdNote(StringBuilder ddNote) {
		this.ddNote = ddNote;
	}
	public StringBuilder getPdProcess() {
		return pdProcess;
	}
	public void setPdProcess(StringBuilder pdProcess) {
		this.pdProcess = pdProcess;
	}
	public StringBuilder getPdNote() {
		return pdNote;
	}
	public void setPdNote(StringBuilder pdNote) {
		this.pdNote = pdNote;
	}
	public StringBuilder getLrrocess() {
		return lrrocess;
	}
	public void setLrrocess(StringBuilder lrrocess) {
		this.lrrocess = lrrocess;
	}
	public StringBuilder getLrNote() {
		return lrNote;
	}
	public void setLrNote(StringBuilder lrNote) {
		this.lrNote = lrNote;
	}
	public StringBuilder getCsProcess() {
		return csProcess;
	}
	public void setCsProcess(StringBuilder csProcess) {
		this.csProcess = csProcess;
	}
	public StringBuilder getCsNote() {
		return csNote;
	}
	public void setCsNote(StringBuilder csNote) {
		this.csNote = csNote;
	}
	
	
}
