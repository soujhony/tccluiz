
package edu.furb.sistemanfe.view;

import javax.inject.Inject;

import br.gov.frameworkdemoiselle.annotation.PreviousView;
import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.gov.frameworkdemoiselle.template.AbstractEditPageBean;
import br.gov.frameworkdemoiselle.transaction.Transactional;
import edu.furb.sistemanfe.business.EmitenteBC;
import edu.furb.sistemanfe.domain.Emitente;

@ViewController
@PreviousView("./emitente_list.jsf")
public class EmitenteEditMB extends AbstractEditPageBean<Emitente, Long> {

	private static final long serialVersionUID = 1L;

	@Inject
	private EmitenteBC emitenteBC;
	

	
	@Override
	@Transactional
	public String delete() {
		this.emitenteBC.delete(getId());
		return getPreviousView();
	}
	
	@Override
	@Transactional
	public String insert() {
		this.emitenteBC.insert(this.getBean());
		return getPreviousView();
	}
	
	@Override
	@Transactional
	public String update() {
		this.emitenteBC.update(this.getBean());
		return getPreviousView();
	}
	
	@Override
	protected Emitente handleLoad(Long id) {
		return this.emitenteBC.load(id);
	}	
}