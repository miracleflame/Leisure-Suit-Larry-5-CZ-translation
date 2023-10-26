;;; Sierra Script 1.0 - (do not remove this comment)
(script# 110)
(include sci.sh)
(use Main)
(use LLRoom)
(use Class_255_0)
(use n958)
(use PicView)
(use Obj)

(public
	rm110 0
)

(procedure (localproc_048e param1 param2)
	(Display
		param1
		dsCOORD
		(+ param2 1)
		43
		dsWIDTH
		158
		dsALIGN
		1
		dsCOLOR
		global122
		dsFONT
		global175
	)
	(Display
		param1
		dsCOORD
		param2
		42
		dsWIDTH
		158
		dsALIGN
		1
		dsCOLOR
		61
		dsFONT
		global175
	)
)

(instance rm110 of LLRoom
	(properties
		picture 115
	)
	
	(method (init)
		(larryPic init:)
		(self style: (if (proc0_6 0) 9 else 8))
		(super init:)
		(proc958_0 129 1)
		(proc958_0 128 115 116)
		(gLl5KDHandler addToFront: self)
		(gLl5MDHandler addToFront: self)
		(proc0_13 120)
		(self setScript: sCartoon)
	)
	
	(method (dispose)
		(super dispose: &rest)
		(gLl5KDHandler delete: self)
		(gLl5MDHandler delete: self)
		(gLongSong fade: 0 15 12 1)
	)
	
	(method (handleEvent pEvent)
		(if
			(and
				(pEvent type?)
				(!= (pEvent message?) KEY_ESCAPE)
				(!= (pEvent message?) KEY_ALT_a)
				(!= (pEvent message?) KEY_ALT_r)
				(!= (pEvent message?) KEY_ALT_t)
			)
			(if
				(proc255_0
					110
					0
					80
					{Fast Forward}
					82
					990
					11
					0
					106
					81
					{Really? Show Me!}
					1
					81
					{Oops}
					0
				)
				(gIconBar
					curIcon: (gIconBar at: 5)
					handleEvent: (pEvent type: 4 message: 27 yourself:)
				)
			)
			(pEvent claimed: 1)
		else
			(super handleEvent: pEvent &rest)
		)
	)
)

(instance sCartoon of Script
	(properties)
	
	(method (changeState newState &tmp [temp0 100])
		(switch (= state newState)
			(0 (= cycles 2))
			(1
				(global2 drawPic: (global2 picture?))
				(localproc_048e {Executive Producer\n\nKen Williams} 160)
				(= seconds 4)
			)
			(2
				(global2 drawPic: (global2 picture?))
				(localproc_048e {Creative Director\n\nBill Davis} 160)
				(= seconds 4)
			)
			(3
				(global2 drawPic: (global2 picture?))
				(localproc_048e {Director\n\nAl Lowe} 160)
				(= seconds 4)
			)
			(4
				(global2 drawPic: (global2 picture?))
				(localproc_048e {Producer\n\nGuruka Singh Khalsa} 160)
				(= seconds 4)
			)
			(5
				(global2 drawPic: (global2 picture?))
				(larryPic dispose:)
				(pattiPic init:)
				(= ticks 120)
			)
			(6
				(global2 drawPic: (global2 picture?))
				(localproc_048e {Game Designer\n\nAl Lowe} 0)
				(= seconds 4)
			)
			(7
				(global2 drawPic: (global2 picture?))
				(localproc_048e {Production Designer\n\nAndy Hoyos} 0)
				(= seconds 4)
			)
			(8
				(global2 drawPic: (global2 picture?))
				(localproc_048e {Art Designer\n\nJane Cardinal} 0)
				(= seconds 4)
			)
			(9
				(global2 drawPic: (global2 picture?))
				(localproc_048e {Lead Programmer\n\nBrian K. Hughes} 0)
				(= seconds 4)
			)
			(10
				(global2 drawPic: (global2 picture?))
				(localproc_048e {Composer\n\nCraig Safan} 0)
				(= seconds 4)
			)
			(11
				(gLongSong fade: 0 15 12 1)
				(global2 drawPic: 1 6)
				(= seconds 3)
			)
			(12
				(proc0_14 110 1)
				(gIconBar enable:)
				(global2 newRoom: 120)
				(self dispose:)
			)
		)
	)
)

(instance pattiPic of View
	(properties
		x 170
		y 177
		view 115
		signal $0011
	)
)

(instance larryPic of View
	(properties
		x 173
		y 179
		view 116
		signal $0011
	)
)
