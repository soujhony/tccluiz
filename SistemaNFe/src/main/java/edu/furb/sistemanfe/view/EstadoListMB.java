package edu.furb.sistemanfe.view;

import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import br.gov.frameworkdemoiselle.annotation.NextView;
import br.gov.frameworkdemoiselle.annotation.PreviousView;
import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.gov.frameworkdemoiselle.template.AbstractListPageBean;
import br.gov.frameworkdemoiselle.transaction.Transactional;
import edu.furb.sistemanfe.business.EstadoBC;
import edu.furb.sistemanfe.domain.Estado;

@ViewController
@NextView("./estado_edit.jsf")
@PreviousView("./estado_list.jsf")
public class EstadoListMB extends AbstractListPageBean<Estado, Long> {

	private static final long serialVersionUID = 1L;

	@Inject
	private EstadoBC estadoBC;
	
	@Override
	protected List<Estado> handleResultList() {
		return this.estadoBC.findAll();
	}
	
	@Transactional
	public String deleteSelection() {
		boolean delete;
		for (Iterator<Long> iter = getSelection().keySet().iterator(); iter.hasNext();) {
			Long id = iter.next();
			delete = getSelection().get(id);
			if (delete) {
				estadoBC.delete(id);
				iter.remove();
			}
		}
		return getPreviousView();
	}

}